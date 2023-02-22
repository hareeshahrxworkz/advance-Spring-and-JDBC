package com.xworkz.flight.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FlightDTO {
	@NotNull(message = "Values does Null Please enter  Company Name")
	@Size(min = 3, max = 30, message = "Size must be grether than 3 less than 30")
	private String name;
	@NotNull(message = "Values does Null Please enter  Flight Name")
	@Size(min = 3, max = 30, message = "Size must be grether than 3 less than 30")
	private String fname;
	@NotNull(message = "Values does Null Please enter Flight  Cost")
	@Size(min = 3, max = 30, message = "Size must be grether than 3 less than 30")
	private String cost;
	@NotNull(message = "Values does Null Please enter Flight  Cost")
	private String type;
	@NotNull(message = "Values does Null Please enter Flight  Cost")
	private String country;

}
