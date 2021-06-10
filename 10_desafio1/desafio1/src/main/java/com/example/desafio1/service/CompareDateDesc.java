package com.example.desafio1.service;

import com.example.desafio1.model.ProductPost;

import java.util.Comparator;

public class CompareDateDesc implements Comparator<ProductPost> {

    @Override
    public int compare(ProductPost post1, ProductPost post2) {
        int r = -1;
        if(post1.getDate().before(post2.getDate()))
        {
            r = 1;
        }

        return r;
    }
}
