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

    Product product1 = new Product(1,"Silla Gamer","Gamer","Racer"
            ,"Red & Black","Especial Edition");
    Product product2 = new Product(2,"Pulsefire FPS Pro","Mouse","Hyperx"
            ,"Black with RGB","Pro Edition");
    Product product3 = new Product(62,"Headset RGB Inalambrico","Gamer","Razer"
            ,"Green with RGB","Sin Bateria");

    public void addProducts(){
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
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
