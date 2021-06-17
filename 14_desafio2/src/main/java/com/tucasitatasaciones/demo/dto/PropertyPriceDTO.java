package com.tucasitatasaciones.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyPriceDTO {
    private int id;
    @JsonProperty("prop_name")
    private String name;
    @JsonProperty("prop_price")
    private double price;
}
