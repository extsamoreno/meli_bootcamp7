package com.example.linktracker.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class LinkDTO {
    private int linkId;
    private String link;
    private boolean estado;
    private int cantidadRedirecciones;
}
