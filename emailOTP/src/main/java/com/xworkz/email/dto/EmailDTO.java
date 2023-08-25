package com.xworkz.email.dto;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmailDTO {
	private int id;
	@NotNull(message = "Not Blank Email")
	private String email;
	@NotNull(message = "Not Blank Name")
	@Size(min = 3, max = 20, message = "Name must be min 3 maxmium 10")
	private String lname;
	@NotNull(message = "Not Blank Otp")
	@Size(min = 3, max = 20, message = "Name must be min 3 maxmium 10")
	private String otp;
	@NotNull(message = "Not Blank Name")
	@Size(min = 3, max = 20, message = "Name must be min 3 maxmium 20")
	private String fName;
	@NotNull(message = "Not Blank Mobile No")
	@Size(min = 3, max = 20, message = "Name must be min 9 maxmium 10")
	private String mobileNo;

}
