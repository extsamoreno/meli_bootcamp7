package com.desafio_1.demo.repositories;

import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.Product;
import com.desafio_1.demo.models.ProductDetail;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Repository
public class ProductRepository implements IProductRepository{

    private ArrayList<Product> listProducts = new ArrayList<>();

    @Override
    public Product addProduct(Product product) throws UnhandledException {

        try{
            int id = listProducts.size()+1;
            ProductDetail detail = product.getDetail();

            product.setIdPost(id);
            product.setDate(LocalDate.now());
            product.setDetail(new ProductDetail(id, detail.getProductName(),detail.getType(), detail.getBrand(), detail.getColor(),detail.getNotes()));
            listProducts.add(product);
            return product;
        }catch(Exception ex){
            throw new UnhandledException(ex.getMessage());
        }

    }
}
