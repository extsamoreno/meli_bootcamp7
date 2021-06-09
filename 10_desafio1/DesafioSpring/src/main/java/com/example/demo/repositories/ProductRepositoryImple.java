package com.example.demo.repositories;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class ProductRepositoryImple implements ProductRepository{

    @Autowired
    UserRepositoryImple userRepositoryImple;
    private ArrayList<Product> productsList = new ArrayList<>();

    Product product = new Product(1,"Silla Gamer","Gamer","Racer"
            ,"Red & Black","Especial Edition");

    public void addProducts(){
        productsList.add(product);
    }

    @Override
    public Product findProductById(int product_id) {
        Product productR = null;
        for(Product product:productsList){
            if( product.getProduct_id() == product_id){
                productR = product;
            }
        }

        if(productR == null){

        }
        return productR;
    }

}
