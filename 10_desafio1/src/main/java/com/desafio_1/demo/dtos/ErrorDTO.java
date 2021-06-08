package com.desafio_1.demo.dtos;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String message;
    private String name;
}