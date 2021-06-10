package com.meli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return productId.intValue() == that.getProductId().intValue()
                && productName.compareTo(that.productName) == 0
                && type.compareTo(that.type) == 0
                && brand.compareTo(that.brand) == 0
                && color.compareTo(that.color) == 0
                && notes.compareTo(that.notes) == 0
                ;
    }

}
