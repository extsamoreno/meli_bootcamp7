package com.example.demo.service.dto;

import com.example.demo.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Double calorias;
    private List<Ingrediente> ingredientes;
    private CaloriasDTO caloriasMax;
}
