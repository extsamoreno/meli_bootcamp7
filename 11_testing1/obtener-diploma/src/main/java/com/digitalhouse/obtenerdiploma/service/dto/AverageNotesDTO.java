package com.digitalhouse.obtenerdiploma.service.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AverageNotesDTO {

    private String studentName;
    private String message;
    private double averageScore;
    private List<SubjectDTO> subjects;

}
