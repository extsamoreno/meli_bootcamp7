package com.implementacion.hibernate2.controller.dto.dentists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistAndTurnsDTO {

    private String name;
    private long turns;
}
