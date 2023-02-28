package com.xworkz.hareeshaxworkz.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter

public class HareeshaDTO {
	private int id;
	@NotNull(message = "Not Blank Name")
	@Size(min = 3, max = 20, message = "Name must be min 3 maxmium 20")
	private String name;
	@NotNull(message = "Not Blank Type")
	@Size(min = 3, max = 20, message = "Type must be min 3 maxmium 20")
	private String type;
	@NotNull
	private String online;
	@NotNull(message = "Not Blank playars")
	private Integer playars;
	@NotNull(message = "Not Blank Wepon")
	@Size(min = 3, max = 20, message = "Wepon must be min 3 maxmium 20")
	private String Wepon;
	@NotNull(message = "Not Blank NoOfLevels")
	private Integer NoOfLevels;

}
