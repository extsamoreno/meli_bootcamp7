package com.example.challenge.Services.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Boolean hasPromo;
    private double discount;
}
