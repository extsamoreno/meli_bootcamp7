package com.example.tucasita.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class HouseWithTotalValueDTO {
    private String name;
    private double totalValue;
}
