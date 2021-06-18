package desafio2.testing.service.dto;


import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseMeterPropertyDTO {
    private String prop_name;
    private double squareMeter;
}
