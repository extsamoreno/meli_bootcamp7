package com.example.projectspring3.controller.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesResponse {
    private String name;
    private int calories;
}
