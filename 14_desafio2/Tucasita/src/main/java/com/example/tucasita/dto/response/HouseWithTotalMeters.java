package com.example.tucasita.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class HouseWithTotalMeters {
    private String name;
    private double totalMeters;
}
