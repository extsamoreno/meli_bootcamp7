package com.desafio2.testing.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadModel {


    private String prop_name;
    private BarrioModel district;
    private ArrayList<AmbienteModel> ambientes;
    private int cantAmbientes;



}
