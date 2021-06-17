package desafio2.testing.service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HousePriceDTO {
    private String prop_name;
    private double price; //precio
}