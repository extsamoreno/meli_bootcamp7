package com.example.Challenge.repository;


import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.model.Product;
import com.example.Challenge.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements  IProductRepository{
    @Autowired
    IUserRepository iUserRepository;

    public final List<Product> dataBaseProducts = new ArrayList<>();

    @Override
    public String createPost(Product product) {
        if(product!= null) {
            dataBaseProducts.add(product);
            return "OK";
        }
        return "Fail";
    }

    @Override
    public List<Product> getAllProductsFollowed(Integer userId) {
        List<Product> listResult = new ArrayList<>();
        User user = iUserRepository.getUserById(userId);

        for(int i=0; i<user.getFollowed().size(); i++){
            for(int j=0; j<dataBaseProducts.size();j++){
                if(user.getFollowed().get(i).getIdUser()== dataBaseProducts.get(j).getUserId()){
                    listResult.add(dataBaseProducts.get(j));
                }
            }
        }
        return listResult;
    }

    @Override
    public List<Product> getAllSellerProducts(Integer userId) {
        List<Product> listResult = new ArrayList<>();
        for(int i=0 ;i<dataBaseProducts.size() ; i++){
            if(dataBaseProducts.get(i).getUserId().equals(userId)){
                listResult.add(dataBaseProducts.get(i));
            }
        }
        return listResult;
    }

    @Override
    public List<Product> getAllSellerPromoProducts(Integer userId) {
        List<Product> listResult = new ArrayList<>();
        for(int i=0 ;i<dataBaseProducts.size() ; i++){
            if(dataBaseProducts.get(i).getUserId().equals(userId) && dataBaseProducts.get(i).isHasPromo()){
                listResult.add(dataBaseProducts.get(i));
            }
        }
        return listResult;
    }

    @Override
    public String createPromoPost(Product product) {
        if(product!= null) {
            dataBaseProducts.add(product);
            return "OK";
        }
        return "Fail";
    }
}
