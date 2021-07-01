package com.example.muelitas.dto;

import lombok.*;

@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProfessionalDTO {
    private Long id;
    private String name;
    private String record;
    private String license;
}
