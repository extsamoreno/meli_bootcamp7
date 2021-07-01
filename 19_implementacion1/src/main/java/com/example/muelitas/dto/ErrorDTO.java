package com.example.muelitas.dto;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String description;
}
