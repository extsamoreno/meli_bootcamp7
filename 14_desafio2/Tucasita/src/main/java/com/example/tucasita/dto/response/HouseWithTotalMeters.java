package com.example.tucasita.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HouseWithTotalMeters {
    private String name;
    private double totalMeters;
}
