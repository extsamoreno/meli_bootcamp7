package com.meli.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TotalMetersResponseDTO {
    private String nameHouse;
    private Double totalMeters;
}
