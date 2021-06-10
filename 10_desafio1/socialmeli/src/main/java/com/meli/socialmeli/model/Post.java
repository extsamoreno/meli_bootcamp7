package com.meli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Integer postId;
    private Integer userId;
    private LocalDate dateCreation;
    private LocalDate dateModification;
    private Integer categoryId;
    private Product product;
    private double price;
    private boolean hasPromo;
    private double discount;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post that = (Post) o;
        return userId.equals(that.userId)
                && categoryId.equals(that.categoryId)
                && price == that.price
                && hasPromo == that.hasPromo
                && discount == discount
                && product.equals(that.product)
                ;
    }

}
