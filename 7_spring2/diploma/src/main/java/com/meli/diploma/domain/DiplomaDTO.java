package com.meli.diploma.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DiplomaDTO {
    private String student;
    private double average;
    private String message;
}
