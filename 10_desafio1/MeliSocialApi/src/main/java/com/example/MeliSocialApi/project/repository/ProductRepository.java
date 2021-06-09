package com.example.MeliSocialApi.project.repository;

import com.example.MeliSocialApi.project.model.Product;
import com.example.MeliSocialApi.project.model.ProductDetails;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    private static Map<Integer, Product> products = new HashMap<Integer, Product>();
    private static Map<Integer, ProductDetails> productDetails = new HashMap<Integer, ProductDetails>();
    static {
        ProductDetails details100 = new ProductDetails(100,"Sillas Gamer","Gamer","Racer","Red & Black","Special edition");
        ProductDetails details101 = new ProductDetails(100,"Headset RGB Inalámbrico","Gamer","Racer","Green","No battery");
        productDetails.put(details100.getProductId(),details100);
        productDetails.put(details101.getProductId(),details101);
        products.put(10,new Product(1,10, Date.valueOf(LocalDate.of(2021,6,8)),details100,150,1524));
        products.put(11,new Product(1,11, Date.valueOf(LocalDate.of(2021,5,24)),details100,150,1570.24));
        products.put(12,new Product(1,12, Date.valueOf(LocalDate.of(2021,6,02)),details100,150,1505.07));
        products.put(13,new Product(1,13, Date.valueOf(LocalDate.of(2021,6,4)),details101,150,300.70));
    }
    // (user1): prod 10 -> cat 100, -1day, prod 11 -> cat 100, -16day, prod 12 -> cat 11, -6day, prod 13 -> cat 11, -4day

    public Map<Integer, ProductDetails> getDetails() {
        return productDetails;
    }
    public Map<Integer, Product> getProducts() {
        return products;
    }
}
