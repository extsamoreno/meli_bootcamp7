package com.example.challenge.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCountDTO {
    private int id;
    private String name;
    private int count;
}
