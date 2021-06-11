package com.meli.diploma.dto;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class DiplomaDTO {

    private String studentName;
    private double averageScore;
    private String message;
    private List<SubjectDTO> subjects;

}
