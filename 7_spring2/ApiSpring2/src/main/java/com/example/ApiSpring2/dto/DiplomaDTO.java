package com.example.ApiSpring2.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class DiplomaDTO {
    private String msg;
    private float avg;
    private StudentDTO student;
}
