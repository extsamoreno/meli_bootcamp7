package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	int postID;
	String date;
	int detail;
	int category;
	float price;
	boolean hasPromo;
	float discount;
}
