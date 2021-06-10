package com.example.demo.services.mappers;

import com.example.demo.dtos.DetailDTO;
import com.example.demo.model.Product;

public class ProductMapper {

     public static Product toProduct(DetailDTO detailDTO){
        return new Product(detailDTO.getProduct_id()
                ,detailDTO.getProductName()
                ,detailDTO.getType()
                ,detailDTO.getBrand()
                ,detailDTO.getColor()
                ,detailDTO.getNotes()
        );
    }

    public static DetailDTO toDetailDTO(Product product){
        return new DetailDTO(product.getProduct_id()
                ,product.getProductName()
                ,product.getType()
                ,product.getBrand()
                ,product.getColor()
                ,product.getNotes()
        );
    }
}
