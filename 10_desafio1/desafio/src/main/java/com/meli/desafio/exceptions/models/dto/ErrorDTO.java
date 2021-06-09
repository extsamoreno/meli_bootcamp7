package com.meli.desafio.exceptions.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {
    private String name;
    private String message;
}
