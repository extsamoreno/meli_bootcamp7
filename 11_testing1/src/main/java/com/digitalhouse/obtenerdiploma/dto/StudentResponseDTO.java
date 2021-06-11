package com.digitalhouse.obtenerdiploma.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDTO {

    private String studentName;
    private List<SubjectDTO> subjects;

}
