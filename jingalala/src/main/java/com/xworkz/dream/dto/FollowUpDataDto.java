package com.xworkz.dream.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FollowUpDataDto {
	
	private List<FollowUpDto> followUpData;
	private int size;

}
