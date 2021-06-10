package com.example.demo.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull(message="El 'product_id' es un campo requerido.")
    private int product_id;
    @NotEmpty(message="El 'product_name' es un campo requerido.")
    private String product_name;
    private String type, brand, color, notes;
}
