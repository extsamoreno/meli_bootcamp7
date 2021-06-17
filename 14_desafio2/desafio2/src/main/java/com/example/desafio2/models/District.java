package com.example.desafio2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private String name;
    private double price;
}
