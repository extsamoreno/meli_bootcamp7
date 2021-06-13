package com.digitalhouse.obtenerdiploma.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ErrorDTO {
    private String name;
    private String message;

    public ErrorDTO(String name, String msg) {
        this.name = name;
        this.message = msg;
    }
}
