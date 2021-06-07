package com.example.springboot.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String message;
}
