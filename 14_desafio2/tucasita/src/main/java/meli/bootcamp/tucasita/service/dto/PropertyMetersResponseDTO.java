package meli.bootcamp.tucasita.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyMetersResponseDTO {

    private double meters;
    private PropertyDTO property;

}
