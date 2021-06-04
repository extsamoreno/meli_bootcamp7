package com.example.spring4.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String message;
}
