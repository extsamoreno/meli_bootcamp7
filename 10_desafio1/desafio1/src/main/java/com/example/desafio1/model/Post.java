package com.example.desafio1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	int postID;
	@JsonFormat(pattern = "dd-MM-yyyy")
	Date date;
	int detail;
	int category;
	float price;
	boolean hasPromo;
	float discount;
}
