package com.example.tucasita.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class HouseWithTotalValue {
    private String name;
    private double totalValue;
}
