package com.tucasitatasaciones.tucasitatasaciones.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomWithPriceDTO extends RoomDTO {
    private double price;
}
