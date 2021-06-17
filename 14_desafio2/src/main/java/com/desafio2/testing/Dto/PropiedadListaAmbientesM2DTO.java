package com.desafio2.testing.Dto;

import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropiedadListaAmbientesM2DTO {

    String nombre;
    ArrayList<AmbienteDTO> listaAmbientes;


}
