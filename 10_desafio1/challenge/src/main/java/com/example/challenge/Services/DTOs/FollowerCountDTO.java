package com.example.challenge.Services.DTOs;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerCountDTO {
    private int id;
    private String name;
    private int count;
}
