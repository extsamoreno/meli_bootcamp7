package com.spring4.ejercicios.link.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {

    private String name;
    private String message;
}
