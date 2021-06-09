package com.example.MeliSocialApi.project.service.mapper;

import com.example.MeliSocialApi.project.model.Product;
import com.example.MeliSocialApi.project.model.ProductDetails;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductDetailDTO;
import com.example.MeliSocialApi.project.service.dto.ProductUserDTOResponse;

import java.util.List;

public class ProductMapper {
    public static ProductDetails productDetailsDTOToDetails(ProductDetailDTO product){
        return new ProductDetails(product.getProductId(),product.getProductName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }
    public static ProductDetailDTO productDetailsToDTO(ProductDetails product){
        return new ProductDetailDTO(product.getProductId(),product.getProductName(),product.getType(),product.getBrand(),product.getColor(),product.getNotes());
    }
    public static Product productDetailsDTOToDetails(ProductDTO product, ProductDetails details){
        return new Product(product.getUserId(),product.getIdPost(),product.getDate(),details,product.getCategory(),product.getPrice());
    }
    public static ProductDTO productToProductDTO(Product product, ProductDetailDTO details){
        return new ProductDTO(product.getUserId(),product.getIdPost(),product.getDate(),details,product.getCategory(),product.getPrice());
    }
    public static ProductUserDTOResponse productUserToDTO(Integer userId, List<ProductDTO> posts){
        return new ProductUserDTOResponse(userId,posts);
    }
}