package com.example.linktracker.dtos.response;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class EstadisticaResponseDTO {
    private String link;
    private int idLink;
    private int cantidadRedirecciones;
}