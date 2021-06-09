package com.example.MeliSocialApi.project.repository;

import com.example.MeliSocialApi.project.model.Product;
import com.example.MeliSocialApi.project.model.ProductDetails;

import java.util.Map;

public interface IProductRepository {
    Map<Integer, ProductDetails> getDetails();
    Map<Integer, Product> getProducts();
}
