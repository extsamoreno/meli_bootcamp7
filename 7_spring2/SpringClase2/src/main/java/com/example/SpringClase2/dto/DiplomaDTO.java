package com.example.springclase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaDTO {
    private String message;
    private Double average;
    private String studentName;
}
