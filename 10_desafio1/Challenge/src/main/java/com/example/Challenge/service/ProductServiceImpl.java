package com.example.Challenge.service;

import com.example.Challenge.dto.ProductDTO;
import com.example.Challenge.dto.ProductResponseDTO;
import com.example.Challenge.mapper.MapperProduct;
import com.example.Challenge.model.Product;
import com.example.Challenge.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

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
    public String newPost(Product product) {
        //System.out.println(product.getDateFromString());
        return iProductRepository.createPost(product);
    }



    @Override
    public List<Product> getAllProduct(Integer userId) {
        return iProductRepository.getAllProducts(userId);

    }
    @Override
    public ProductResponseDTO getPostById(Integer userId, String order) {
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
