package com.example.desafio1.exceptions.product;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class InvalidDateInPostException extends ProductException {
    public InvalidDateInPostException(LocalDate date) {
        super("La fecha de la publicación: " + date + " no puede ser mayor al día de la fecha, " +
                "por favor, ingrese otra diferente.", HttpStatus.BAD_REQUEST);
    }
}
