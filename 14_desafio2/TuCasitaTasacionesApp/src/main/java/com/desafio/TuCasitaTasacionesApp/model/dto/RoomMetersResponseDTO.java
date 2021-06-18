package com.desafio.TuCasitaTasacionesApp.model.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class RoomMetersResponseDTO {
    private String name;
    private Double meter;

    public RoomMetersResponseDTO(String name, Double meter) {
       this.name = name;
       this.meter = meter;
    }
}
