package com.implementacion.hibernate2.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private Long id;
    private String name;
    private Long schedule_id;
}
