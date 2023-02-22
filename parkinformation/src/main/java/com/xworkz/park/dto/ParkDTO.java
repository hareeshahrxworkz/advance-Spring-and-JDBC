package com.xworkz.park.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ParkDTO {
	@NotBlank(message = "Name Is not Blank")
	@Size(min = 3, max = 25, message = "You are enter min 3 character and maximum 25")
	private String visitorNme;
	@NotBlank(message = "ParkName Is not Blank")
	@Size(min = 3, max = 25, message = "You are enter min 3 character and maximum 25")
	private String parkName;
	@NotBlank(message = "place is not blank")
	private String place;
	@NotBlank(message = "week is not blank")
	private String week;
	@NotBlank
	@Size(min = 3, max = 25, message = "You are enter min 3 character and maximum 25")
	private String review;

}
