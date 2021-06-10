package com.example.desafio1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoDTO {
	int postID;
	@JsonFormat(pattern = "dd-MM-yyyy")
	Date date;
	ProductDTO detail;
	int category;
	float price;
	boolean hasPromo;
	float discount;
}
