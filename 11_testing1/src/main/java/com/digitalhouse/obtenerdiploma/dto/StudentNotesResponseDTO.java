package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentNotesResponseDTO {

    private String studentName;
    private String message;
    private double averageScore;
    private List<SubjectDTO> subjects;
}
