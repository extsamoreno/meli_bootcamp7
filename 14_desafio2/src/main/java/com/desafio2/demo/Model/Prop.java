package com.desafio2.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prop {
    private String name;
    private District district;
    private List<Environment> environments;
    private double totalPrice;
}
