package com.example.desafio1.repositories;

import com.example.desafio1.models.Publishing;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    List<Publishing> publishingList = new ArrayList<>();

    @Override
    public void addPublishing(Publishing pub) {
        publishingList.add(pub);
        //Log temporal para visualizar el listado de publicaciones
        for (Publishing publishing : publishingList) {
            System.out.println("Publishing added successfully!");
            System.out.println("Pub id:" + publishing.getIdPost());
            System.out.println("Pub price: " + publishing.getPrice());
            System.out.println("product id:" + publishing.getDetail().getProductId());
        }
    }
}
