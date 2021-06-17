package com.meli.tucasita.dto;

import lombok.Data;

@Data
public class PropertyPriceDTO {

    private String address;
    private String district;
    private double meters;
    private double meterPrice;
    private double propertyPrice;
}
