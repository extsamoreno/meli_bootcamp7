package com.bootcamp.desafio2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentsListDTO {

    private ArrayList<EnvironmentDTO> environments = new ArrayList<>();

}
