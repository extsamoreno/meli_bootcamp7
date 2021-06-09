package com.desafio1.meli.repository.productRepository;

import com.desafio1.meli.model.Category;
import com.desafio1.meli.model.*;
import com.desafio1.meli.repository.userRepository.*;
import com.desafio1.meli.service.DTO.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ProductRepositoy implements IProductrepository {

    private ArrayList<Publication> publications ;

    @Autowired
    IUserrepository iUserrepository;


    public ProductRepositoy() {
        this.publications = new ArrayList<>();
    }

    @Override
    public boolean newProduct(RequestNewProduct requestNewProduct){
        try{
            Product product = new Product(
                    requestNewProduct.getProducts().getId(),
                    requestNewProduct.getProducts().getName(),
                    requestNewProduct.getProducts().getType(),
                    requestNewProduct.getProducts().getBrand(),
                    requestNewProduct.getProducts().getColor(),
                    requestNewProduct.getProducts().getNotes()
            );

            Category category = new Category(requestNewProduct.getCategory().getName());

            Publication publication = new Publication(
                    requestNewProduct.getUserId(),
                    iUserrepository.findUserById(requestNewProduct.getId_post()),
                    requestNewProduct.getDate(),
                    product,
                    category,
                    requestNewProduct.getPrice()
                    );

            this.publications.add(publication);

            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public RequestFollowedProductList getProductListFollow (Integer userId, LocalDate dateFrome, LocalDate dateBefore){
        RequestFollowedProductList requestFollowedProductList = new RequestFollowedProductList();
        User user = iUserrepository.findUserById(userId);
        ArrayList<User> listFollowUser =  iUserrepository.listFollow(userId).getFollow();
        requestFollowedProductList.setUserId(userId);
        requestFollowedProductList.setPosts((ArrayList<Publication>) this.publications.stream()
                .filter(publication -> publication.getUser_id() == userId)
                .filter(publication -> publication.getDate().isAfter(dateFrome) && publication.getDate().isBefore(dateBefore))
                .collect(Collectors.toList()));

        return requestFollowedProductList ;

    }


}
