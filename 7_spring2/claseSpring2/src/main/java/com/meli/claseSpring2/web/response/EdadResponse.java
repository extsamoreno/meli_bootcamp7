package com.meli.claseSpring2.web.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EdadResponse {
    private int dia;
    private int mes;
    private int anio;
    private int aniosPersona;
}
