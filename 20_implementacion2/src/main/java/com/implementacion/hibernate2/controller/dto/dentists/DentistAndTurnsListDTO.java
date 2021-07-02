package com.implementacion.hibernate2.controller.dto.dentists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistAndTurnsListDTO {

    private List<DentistAndTurnsDTO> dentists;
}
