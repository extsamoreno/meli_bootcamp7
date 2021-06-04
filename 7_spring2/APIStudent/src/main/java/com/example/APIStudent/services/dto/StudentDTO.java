package com.example.APIStudent.services.dto;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String name, message;
    private double prom;

}
