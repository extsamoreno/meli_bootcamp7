package com.desafrio2.Desafio1.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentDTO {
    private String name;
    private double totalMeter;
}
