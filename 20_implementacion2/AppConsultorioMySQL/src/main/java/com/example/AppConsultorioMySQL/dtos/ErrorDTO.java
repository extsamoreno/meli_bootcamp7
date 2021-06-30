package com.example.AppConsultorioMySQL.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private String name;
}
