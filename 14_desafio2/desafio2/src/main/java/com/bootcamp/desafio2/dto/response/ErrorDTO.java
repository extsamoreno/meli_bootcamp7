package com.bootcamp.desafio2.dto.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String name;
    private String message;
}