package com.xworkz.dream.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.apache.logging.log4j.status.StatusData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.xworkz.dream.dto.BasicInfoDto;
import com.xworkz.dream.dto.BatchDetailsDto;
import com.xworkz.dream.dto.BirthDayInfoDto;
import com.xworkz.dream.dto.CourseDto;
import com.xworkz.dream.dto.EducationInfoDto;
import com.xworkz.dream.dto.FollowUpDataDto;
import com.xworkz.dream.dto.FollowUpDto;
import com.xworkz.dream.dto.ReferalInfoDto;
import com.xworkz.dream.dto.SheetsDto;
import com.xworkz.dream.dto.StatusDto;
import com.xworkz.dream.dto.SuggestionDto;
import com.xworkz.dream.dto.TraineeDto;
import com.xworkz.dream.dto.utils.User;
import com.xworkz.dream.repo.DreamRepo;
import com.xworkz.dream.util.DreamUtil;
import com.xworkz.dream.wrapper.DreamWrapper;

import freemarker.template.TemplateException;

@Service
public class DreamService {

	@Autowired
	private DreamRepo repo;
	@Autowired
	private DreamWrapper wrapper;
	@Autowired
	private DreamUtil util;

	@Value("${sheets.rowStartRange}")
	private String rowStartRange;
	@Value("${sheets.rowEndRange}")
	private String rowEndRange;
	@Value("${sheets.followUpRowCurrentStartRange}")
	private String followUpRowCurrentStartRange;
	@Value("${sheets.followUpRowCurrentEndRange}")
	private String followUpRowCurrentEndRange;
	@Value("${sheets.traineeSheetName}")
	private String traineeSheetName;
	@Value("${sheets.followUpSheetName}")
	private String followUpSheetName;
	@Value("${sheets.followUprowStartRange}")
	private String followUprowStartRange;
	@Value("${sheets.followUprowEndRange}")
	private String followUprowEndRange;

	private static final Logger logger = LoggerFactory.getLogger(DreamService.class);

	// Rest of your code...
	public ResponseEntity<String> writeData(String spreadsheetId, TraineeDto dto, HttpServletRequest request) throws MessagingException, TemplateException {
		try {
			if (true) {// isCookieValid(request)
				List<List<Object>> data = repo.getIds(spreadsheetId).getValues();
				int size = data.size();
				System.out.println(size);

				dto.setId(size += 1);
				System.out.println(dto.getId());

				List<Object> list = wrapper.extractDtoDetails(dto);
//				for (Object object : list) {
//					System.out.println(object);
//				}

				boolean writeStatus = repo.writeData(spreadsheetId, list);
				// calling method to store date of birth details
				saveBirthDayInfo(spreadsheetId, dto, request);
				if (writeStatus) {
					logger.info("Data written successfully to spreadsheetId: {}", spreadsheetId);
					boolean status = addToFollowUp(dto, spreadsheetId);
					if (status) {
						logger.info("Data written successfully to spreadsheetId and Added to Follow Up: {}",
								spreadsheetId);

						boolean sent = util.sendCourseContent(dto.getBasicInfo().getEmail(),
								dto.getBasicInfo().getTraineeName());
						repo.evictAllCachesOnTraineeDetails();
						if (sent == true) {
							return ResponseEntity.ok("Data written successfully , Added to follow Up , sended course content ");
						} else {
							return ResponseEntity.ok("Email not sent, Data written successfully , Added to follow Up");
						}
					}
					return ResponseEntity.ok("Data written successfully , not added to Follow Up");
				} else {
					logger.warn("Failed to write data to spreadsheetId: {}", spreadsheetId);
					return ResponseEntity.badRequest().body("Failed to write data");
				}
			} else {
				// Invalid cookie
				logger.info("Invalid cookie in the request");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid cookie");
			}
		} catch (IOException e) {
			logger.error("Error occurred while writing data to spreadsheetId: {}", spreadsheetId, e);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data mapping error");

		}
	}

	public boolean addToFollowUp(TraineeDto traineeDto, String spreadSheetId)
			throws IOException, IllegalAccessException {
		FollowUpDto followUpDto = new FollowUpDto();

		BasicInfoDto basicInfo = new BasicInfoDto();
		basicInfo.setTraineeName(traineeDto.getBasicInfo().getTraineeName());
		basicInfo.setEmail(traineeDto.getBasicInfo().getEmail());
		basicInfo.setContactNumber(traineeDto.getBasicInfo().getContactNumber());

		// Set the initialized BasicInfo object to followUpDto
		followUpDto.setBasicInfo(basicInfo);

		followUpDto.setCourseName(traineeDto.getCourseInfo().getCourse());
		followUpDto.setRegistrationDate(LocalDate.now().toString());
		followUpDto.setJoiningDate("Not Confirmed");
		followUpDto.setId(traineeDto.getId());
		followUpDto.setCurrentlyFollowedBy("None");
		followUpDto.setCurrentStatus("New");
		List<Object> data = wrapper.extractDtoDetails(followUpDto);
		repo.saveToFollowUp(spreadSheetId, data);
		return true;
	}

	public ResponseEntity<String> emailCheck(String spreadsheetId, String email, HttpServletRequest request) {
		try {
			if (true) {// isCookieValid(request)
				ValueRange values = repo.getEmails(spreadsheetId);
				if (values.getValues() != null) {
					for (List<Object> row : values.getValues()) {
						if (row.get(0).toString().equalsIgnoreCase(email)) {
							logger.info("Email exists in spreadsheetId: {}", spreadsheetId);
							return ResponseEntity.status(HttpStatus.CREATED).body("Email exists");
						}
					}
				}
				logger.info("Email does not exist in spreadsheetId: {}", spreadsheetId);
				return ResponseEntity.ok("Email does not exist");
			} else {
				// Invalid cookie
				logger.info("Invalid cookie in the request");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid cookie");
			}
		} catch (Exception e) {
			logger.error("An error occurred while checking email in spreadsheetId: {}", spreadsheetId, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	private boolean isCookieValid(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("Xworkz")) {
					System.out.println("Cookie Valid");
					return true;
				}
			}
		}
		return false;
	}

	public ResponseEntity<String> contactNumberCheck(String spreadsheetId, Long contactNumber,
			HttpServletRequest request) {
		try {
			if (true) {// isCookieValid(request)
				ValueRange values = repo.getContactNumbers(spreadsheetId);
				if (values.getValues() != null) {
					for (List<Object> row : values.getValues()) {
						if (row.get(0).toString().equals(String.valueOf(contactNumber))) {
							logger.info("Contact Number exists in spreadsheetId: {}", spreadsheetId);
							return ResponseEntity.status(HttpStatus.CREATED).body("Contact Number exists");
						}
					}
				}
				logger.info("Contact Number does not exist in spreadsheetId: {}", spreadsheetId);
				return ResponseEntity.ok("Contact Number does not exist");
			} else {
				// Invalid cookie
				logger.info("Invalid cookie in the request");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid cookie");
			}
		} catch (Exception e) {
			logger.error("An error occurred while checking Contact Number in spreadsheetId: {}", spreadsheetId, e);
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
		}
	}

	@CacheEvict(value = { "sheetsData", "emailData", "contactData", "getDropdowns","followUpStatusDetails", "followUpDetails" }, allEntries = true)
	@Scheduled(fixedDelay = 43200000) // 12 hours in milliseconds
	public void evictAllCaches() {
		// This method will be scheduled to run every 12 hours
		// and will evict all entries in the specified caches
	}

	

	public ResponseEntity<SheetsDto> readData(String spreadsheetId, int startingIndex, int maxRows) {
		try {
			List<List<Object>> data = repo.readData(spreadsheetId);
			// System.out.println(data.toString());
			List<TraineeDto> dtos = getLimitedRows(data, startingIndex, maxRows);
			// System.out.println(dtos.toString());
			HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();

			SheetsDto dto = new SheetsDto(dtos, data.size());
			return ResponseEntity.ok(dto);
		} catch (IOException e) {

			e.printStackTrace();

		}
		return null;

	}

	public List<TraineeDto> getLimitedRows(List<List<Object>> values, int startingIndex, int maxRows) {
		List<TraineeDto> traineeDtos = new ArrayList<>();

		int endIndex = startingIndex + maxRows;
		int rowCount = values.size();

		ListIterator<List<Object>> iterator = values.listIterator(startingIndex);

		while (iterator.hasNext() && iterator.nextIndex() < endIndex) {
			List<Object> row = iterator.next();

			if (row != null && !row.isEmpty()) {
				TraineeDto traineeDto = wrapper.listToDto(row);
				traineeDtos.add(traineeDto);
			}
		}
		return traineeDtos;
	}

	public List<TraineeDto> filterData(String spreadsheetId, String searchValue) throws IOException {
		if (searchValue != null && !searchValue.isEmpty()) {
			List<List<Object>> data = repo.readData(spreadsheetId);
			List<List<Object>> filteredLists = data.stream()
					.filter(list -> list.stream()
							.anyMatch(value -> value.toString().toLowerCase().contains(searchValue.toLowerCase())))
					.collect(Collectors.toList());
			List<TraineeDto> flist = new ArrayList<TraineeDto>();
			for (List<Object> list2 : filteredLists) {
				TraineeDto dto = wrapper.listToDto(list2);
				flist.add(dto);
			}
			return flist;
		} else {
			return null;
		}
	}

	public ResponseEntity<String> update(String spreadsheetId, String email, TraineeDto dto) {
		try {
			int rowIndex = findRowIndexByEmail(spreadsheetId, email);
			String range = traineeSheetName + rowStartRange + rowIndex + ":" + rowEndRange + rowIndex;
			try {
				List<List<Object>> values = Arrays.asList(wrapper.extractDtoDetails(dto));

				ValueRange valueRange = new ValueRange();
				valueRange.setValues(values);
				UpdateValuesResponse updated = repo.update(spreadsheetId, range, valueRange);
				if(updated.isEmpty()) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred ");
				}else {
					repo.evictAllCachesOnTraineeDetails();
					return ResponseEntity.ok("Updated Successfully");
				}
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred ");

			}

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred ");

		}

	}

	public ResponseEntity<String> updateFollowUp(String spreadsheetId, String email, FollowUpDto followDto)
			throws IOException, IllegalAccessException {
		FollowUpDto followUpDto = getFollowUpDetailsByEmail(spreadsheetId, email);
	
		int rowIndex = findByEmailForUpdate(spreadsheetId, email);
		
		
		String range = followUpSheetName + followUprowStartRange + rowIndex + ":" + followUprowEndRange + rowIndex;
		
		List<List<Object>> values = Arrays.asList(wrapper.extractDtoDetails(followDto));
		
		ValueRange valueRange = new ValueRange();
		valueRange.setValues(values);
		
		UpdateValuesResponse updated = repo.updateFollow(spreadsheetId, range, valueRange);
		if(updated.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred ");
		}else {
			repo.evictAllCachesOnTraineeDetails();
			return ResponseEntity.ok("Updated Successfully");
		}
		
	}
	private int findRowIndexByEmail(String spreadsheetId, String email) throws IOException {

		ValueRange data = repo.getEmails(spreadsheetId);
		List<List<Object>> values = data.getValues();
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				List<Object> row = values.get(i);
				if (row.size() > 0 && row.get(0).toString().equalsIgnoreCase(email)) {
					return i + 3;
				}
			}
		}
		return -1;
	}

	private int findFollowUpRowIndexById(String spreadsheetId, int id) throws IOException {

		List<List<Object>> values = repo.getFollowUpDetails(spreadsheetId);

		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				List<Object> row = values.get(i);
				if (row.size() > 0 && row.get(0).equals(String.valueOf(id))) {
					return i + 2;
				}
			}
		}
		return -1;
	}

	public boolean updateCurrentFollowUp(String spreadsheetId, int id, String currentlyFollowedBy, String currentStatus)
			throws IOException {
		List<List<Object>> followUpData = repo.getFollowUpDetails(spreadsheetId);
		int rowIndex = findFollowUpRowIndexById(spreadsheetId, id);
		String range = followUpSheetName + followUpRowCurrentStartRange + rowIndex + ":" + followUpRowCurrentEndRange
				+ rowIndex;
		System.out.println("----" + rowIndex);
		System.out.println(" ---" + range);
		List<Object> updateData = Arrays.asList(currentlyFollowedBy, currentStatus);
		repo.updateCurrentFollowUpStatus(spreadsheetId, range, updateData);
		return true;

	}

	public ResponseEntity<String> updateFollowUpStatus(String spreadsheetId, StatusDto statusDto,
			HttpServletRequest request) {
		System.out.println("--------Service--------------");
		try {
			statusDto.setAttemptedOn(LocalDateTime.now().toString());
			System.out.println(statusDto.toString());
			List<Object> statusData = wrapper.extractDtoDetails(statusDto);
			System.out.println(statusData.toString());
			boolean status = repo.updateFollowUpStatus(spreadsheetId, statusData);
			updateCurrentFollowUp(spreadsheetId, statusDto.getId(), statusDto.getAttemptedBy(),
					statusDto.getAttemptStatus());
			return ResponseEntity.ok("Follow Status Updated for ID :  " + statusDto.getId());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred in Mapping data");

		} catch (IOException e) {

			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred with credentials file ");
		}

	}

	public ResponseEntity<List<String>> getSearchSuggestion(String spreadsheetId, String value,
			HttpServletRequest request) {
		//SuggestionDto sDto = new SuggestionDto();
		// String values=value.toLowerCase();
		String pattern = ".{3}";
		List<String> suggestion = new ArrayList<>();
		if (value != null) {
			try {
				List<List<Object>> dataList = repo.getEmailsAndNames(spreadsheetId, value);
				List<List<Object>> filteredData = dataList.stream().filter(list -> list.stream().anyMatch(val -> {
					String strVal = val.toString();
					return strVal.toLowerCase().startsWith(value.toLowerCase());
				})).collect(Collectors.toList());

				for (List<Object> list : filteredData) {

					suggestion.add((String)list.get(0).toString());
					suggestion.add((String)list.get(1).toString());
				}

				return ResponseEntity.ok(suggestion);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}

//	public static List<SuggestionDto> getSuggestions(String dataToMatch, List<List<Object>> data) {
//
//		List<Object> list = data.stream().flatMap(List::stream)
//				.filter(value -> value.toString().equalsIgnoreCase(dataToMatch)).collect(Collectors.toList());
//		System.out.println(list.toString());
//		return null;
//	}

	public ResponseEntity<?> getDetailsByEmail(String spreadsheetId, String email, HttpServletRequest request)
			throws IOException {
		List<List<Object>> data = repo.readData(spreadsheetId);
		TraineeDto trainee = null;
		for (List<Object> list : data) {
			if (list.contains(email)) {
				trainee = wrapper.listToDto(list);
			}
		}
		if (trainee != null) {
			return ResponseEntity.ok(trainee);
		} else {
			return new ResponseEntity<>("Email Not Found", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<FollowUpDataDto> getFollowUpDetails(String spreadsheetId, int startingIndex, int maxRows,
			String status) throws IOException {
		List<FollowUpDto> followUpDto = new ArrayList<FollowUpDto>();
		// String traineeStatus=status.toLowerCase();
		if (status != null && !status.isEmpty()) {

			List<List<Object>> lists = repo.getFollowUpDetails(spreadsheetId);

			List<List<Object>> data = lists.stream()
					.filter(list -> list.stream().anyMatch(value -> value.toString().equalsIgnoreCase(status)))
					.collect(Collectors.toList());
			followUpDto = getFollowUpRows(data, startingIndex, maxRows);
			FollowUpDataDto followUpDataDto = new FollowUpDataDto(followUpDto, data.size());
			return ResponseEntity.ok(followUpDataDto);
		}
		return null;
	}

	public List<FollowUpDto> getFollowUpRows(List<List<Object>> values, int startingIndex, int maxRows) {
		List<FollowUpDto> followUpDtos = new ArrayList<>();
		int endIndex = startingIndex + maxRows;
		// int rowCount = values.size();
		ListIterator<List<Object>> iterator = values.listIterator(startingIndex);
		while (iterator.hasNext() && iterator.nextIndex() < endIndex) {
			List<Object> row = iterator.next();

			if (row != null && !row.isEmpty()) {
				FollowUpDto followupDto = wrapper.listToFollowUpDTO(row);

				followUpDtos.add(followupDto);
			}
		}
		return followUpDtos;
	}

	public List<StatusDto> getStatusDetails(String spreadsheetId, int startingIndex, int maxRows, String email,
			HttpServletRequest request) throws IOException {
		List<StatusDto> statusDto = new ArrayList<>();
		List<List<Object>> dataList = repo.getFollowUpStatusDetails(spreadsheetId);
		System.out.println(dataList.toString());
		List<List<Object>> data = dataList.stream()
				.filter(list -> list.stream().anyMatch(value -> value.toString().equalsIgnoreCase(email)))
				.collect(Collectors.toList());
		statusDto = getFollowUpStatusData(data, startingIndex, maxRows);

		return statusDto;
	}

	public List<StatusDto> getFollowUpStatusData(List<List<Object>> values, int startingIndex, int maxRows) {
		List<StatusDto> statusDtos = new ArrayList<>();

		int endIndex = startingIndex + maxRows;
		ListIterator<List<Object>> iterator = values.listIterator(startingIndex);

		while (iterator.hasNext() && iterator.nextIndex() < endIndex) {
			List<Object> row = iterator.next();

			if (row != null && !row.isEmpty()) {
				StatusDto statusDto = wrapper.listToStatusDto(row);
				statusDtos.add(statusDto);
			}
		}

		return statusDtos;
	}

	public ResponseEntity<String> saveDetails(String spreadsheetId, BatchDetailsDto dto, HttpServletRequest request)
			throws IOException, IllegalAccessException {
		List<List<Object>> data = repo.getBatchId(spreadsheetId).getValues();
		int size = data.size();
		dto.setId(size += 1);
		List<Object> list = wrapper.extractDtoDetails(dto);
		boolean save = repo.saveBatchDetails(spreadsheetId, list);
		if (save == true) {
			return ResponseEntity.ok("Batch details added successfully");
		} else {
			return ResponseEntity.ok("Batch details Not added");
		}
	}

	public ResponseEntity<String> saveBirthDayInfo(String spreadsheetId, TraineeDto dto, HttpServletRequest request)
			throws IllegalAccessException, IOException {
		BirthDayInfoDto birthday = new BirthDayInfoDto();
		List<List<Object>> data = repo.getBirthDayId(spreadsheetId).getValues();
		int size = data.size();
		birthday.setDto(dto.getBasicInfo());
		birthday.setId(size += 1);
		List<Object> list = wrapper.extractDtoDetails(birthday);
//		for (Object object : list) {
//			System.out.println(object);
//		}
		boolean save = repo.saveBirthDayDetails(spreadsheetId, list);
		if (save != false) {
			return ResponseEntity.ok("Birth day information added successfully");
		}
		return ResponseEntity.ok("Birth day information Not added");
	}

	

	public FollowUpDto getFollowUpDetailsByEmail(String spreadsheetId, String email) throws IOException {
		// List<FollowUpDto> followUpDto = new ArrayList<FollowUpDto>();
		// String traineeStatus=status.toLowerCase();
		FollowUpDto followUpDto = new FollowUpDto();
		if (email != null && !email.isEmpty()) {
			List<List<Object>> lists = repo.getFollowUpDetails(spreadsheetId);
			List<List<Object>> data = lists.stream()
					.filter(list -> list.stream().anyMatch(value -> value.toString().equalsIgnoreCase(email)))
					.collect(Collectors.toList());
			for (List<Object> list : data) {
				//System.out.println(list.toString());
				followUpDto = wrapper.listToFollowUpDTO(list);
			}
			return followUpDto;
		}
		return null;
	}
	private int findByEmailForUpdate(String spreadsheetId, String email) throws IOException {

		ValueRange data = repo.getEmailList(spreadsheetId);
		List<List<Object>> values = data.getValues();
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				List<Object> row = values.get(i);
				if (row.size() > 0 && row.get(0).toString().equalsIgnoreCase(email)) {
					return i + 2;
				}
			}
		}
		return -1;
	}


}
