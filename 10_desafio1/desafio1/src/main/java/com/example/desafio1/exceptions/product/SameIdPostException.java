package com.example.desafio1.exceptions.product;

import org.springframework.http.HttpStatus;

public class SameIdPostException extends ProductException {
    public SameIdPostException(int idPost) {
        super("La publicación con el id: "
                        + idPost + " ya existe, por favor, ingrese otro diferente.",
                HttpStatus.BAD_REQUEST);
    }
}
