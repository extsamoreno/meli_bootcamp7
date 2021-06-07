package com.example.demo.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiplomaResponseDTO {

    private String studentName;
    private int average;
    private String message;

}
