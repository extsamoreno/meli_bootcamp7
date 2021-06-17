package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTotalMetersByEnvironmentDTO {

    private String nameProperty;
    private List<EnvironmentDTO> environments;
}
