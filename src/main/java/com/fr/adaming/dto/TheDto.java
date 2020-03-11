package com.fr.adaming.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TheDto {
	
	@NotBlank
	private String variety;
	
	@NotBlank
	private String brand;
	
	private int weight;
	
	private boolean inBags;

}
