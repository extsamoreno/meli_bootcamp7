package com.meli.consultorio.exceptions;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String error;
    private String message;
}