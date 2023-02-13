package com.xworkz.hotel.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class CMDTO {
	@NotNull()
	@Size(min = 3, max = 20, message = "You Enter Value is Min 3 and Max 20")
	private String CMName;
	@NotNull
	@NotBlank(message = "state is not blank")
	private String state;
	@NotNull
	@Min(value = 22, message = "Age Must be grether than 22")
	private Integer age;
	@NotNull
	@Min(value = 1, message = "tenure min 1 grether more 1")
	private Integer tenure;
	@NotNull
	private String vaccine;

}
