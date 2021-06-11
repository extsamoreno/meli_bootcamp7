package com.example.demo.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @Size(min = 5, max = 20, message = "El nombre debería tener entre 5 y 20 caracteres")
    private String name;

    @Min(value = 5, message = "El stock mínimo debería ser 5")
    private Integer stock;

}
