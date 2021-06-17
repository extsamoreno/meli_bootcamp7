package com.desafio2.testing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmbienteModel {


    private String enviroment_name;
    private double enviroment_width;
    private double enviroment_length;

}
