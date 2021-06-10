package com.example.challenge.Services.DTOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

    private String message;
    private String name;
}