package com.example.desafio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPost implements Precedeable<ProductPost> {
    private int userId;
    private int id_post;
    private Date date;
    private Product detail;
    private int category;
    private double price;

    @Override
    public int precedeA(ProductPost productPost) {
        return this.getDate().compareTo(productPost.getDate());
    }


    /*@Override
    public int compareTo(ProductPost o) {
        return this.getDate().compareTo(o.getDate());
    }*/

    /*@Override
    public int compare(ProductPost o1, ProductPost o2) {
        int r = -1;
        if (o1.getDate().before(o2.getDate()))
        {
            r = 1;
        }
        return r;
    }*/
}
