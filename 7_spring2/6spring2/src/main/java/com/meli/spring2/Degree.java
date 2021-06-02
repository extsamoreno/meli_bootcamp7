package com.meli.spring2;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Degree {

    private String studentName;
    private String message;
    private double averageGrades;

}
