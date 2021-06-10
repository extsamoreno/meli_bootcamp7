package com.example.Challenge.service;

import com.example.Challenge.dto.ProductDTO;
import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.exception.ProductException;
import com.example.Challenge.exception.UserException;
import com.example.Challenge.exception.UserIdNotFoundException;
import com.example.Challenge.mapper.MapperProduct;
import com.example.Challenge.model.Product;
import com.example.Challenge.model.User;
import com.example.Challenge.repository.IProductRepository;
import com.example.Challenge.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository iUserRepository;

    public List<ProductDTO> getLatestPosts(List<ProductDTO> list) {
        List<ProductDTO> listOut = new ArrayList<>();
        for (ProductDTO product : list) {
            if (product.getDateFromString().isAfter(LocalDate.now().minusWeeks(2))) {
                listOut.add(product);
            }
        }
        return listOut;
    }

    @Override
    public String newPost(Product product) throws ProductException {
        //System.out.println(product.getDateFromString());
        if(product == null) throw new ProductException("invalid product", HttpStatus.BAD_REQUEST);
        return iProductRepository.createPost(product);
    }

    @Override
    public List<Product> getAllProduct(Integer userId) throws UserException {
        User user = iUserRepository.getUserById(userId);
        //Exceptions
        if(user == null) throw new UserIdNotFoundException(userId);
        return iProductRepository.getAllProducts(userId);

    }
    @Override
    public ProductResponseDTO getPostById(Integer userId, String order) throws UserException {

        User user = iUserRepository.getUserById(userId);
        //Exceptions
        if(user == null) throw new UserIdNotFoundException(userId);

        List<ProductDTO> listResult= new ArrayList<>();
        List<Product> listProducts = iProductRepository.getAllProducts(userId);
        for(Product product: listProducts){
            listResult.add(MapperProduct.toProductDTO(product));
        }
        //Sort by date LatestPost
        if(order == null){
            Collections.sort(listResult, (o1, o2) -> o1.getDateFromString().compareTo(o2.getDateFromString()));
            Collections.reverse(listResult);
            return new ProductResponseDTO(userId,getLatestPosts(listResult));
        }
        else if(order.equals("date_asc")){
            Collections.sort(listResult, (o1, o2) -> o1.getDateFromString().compareTo(o2.getDateFromString()));
            return new ProductResponseDTO(userId,listResult);
        }
        else if(order.equals("date_desc")){
            Collections.sort(listResult, (o1, o2) -> o1.getDateFromString().compareTo(o2.getDateFromString()));
            Collections.reverse(listResult);
            return new ProductResponseDTO(userId,listResult);
        }
        else return null;

    }



}
