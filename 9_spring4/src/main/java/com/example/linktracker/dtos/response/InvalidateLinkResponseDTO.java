package com.example.linktracker.dtos.response;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class InvalidateLinkResponseDTO {
    private String link;
    private int linkId;
    private boolean estado;
}
