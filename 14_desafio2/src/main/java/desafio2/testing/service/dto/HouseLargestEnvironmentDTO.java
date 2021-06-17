package desafio2.testing.service.dto;

import desafio2.testing.domian.EnvironmentHouse;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseLargestEnvironmentDTO {
    private String prop_name;
    private EnvironmentHouse environmentHouse;
    private double squareMeter; //metros cuadrados
}
