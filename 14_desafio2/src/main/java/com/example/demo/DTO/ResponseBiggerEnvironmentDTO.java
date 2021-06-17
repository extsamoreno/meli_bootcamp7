package com.example.demo.DTO;

import com.example.demo.entities.Environment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBiggerEnvironmentDTO {

    private String name;
    private int environmentId;
    private double biggerEnvironmentMeters;
    
}
