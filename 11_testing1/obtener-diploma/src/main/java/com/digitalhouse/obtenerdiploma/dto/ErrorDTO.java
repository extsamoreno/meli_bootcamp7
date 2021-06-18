package com.digitalhouse.obtenerdiploma.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ErrorDTO {
    private String nombre;
    private String  mensaje;
}