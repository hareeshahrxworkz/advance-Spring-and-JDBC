package com.xworkz.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfoDto {

	private String qualification;
	private String stream;
	private String yearOfPassout;
	private String collegeName;

}
