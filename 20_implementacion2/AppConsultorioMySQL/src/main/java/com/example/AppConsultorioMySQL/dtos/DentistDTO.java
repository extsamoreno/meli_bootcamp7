package com.example.AppConsultorioMySQL.dtos;

import lombok.*;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {
    private Long id;
    private String name;
    private Long enrollment;
}
