package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements  Comparable{

    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public int compareTo(Object o) {
        return this.productName.compareTo(((ProductDTO)o).getProductName());
    }
}
