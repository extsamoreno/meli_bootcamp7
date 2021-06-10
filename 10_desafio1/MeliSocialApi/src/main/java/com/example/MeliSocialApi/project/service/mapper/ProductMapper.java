package com.example.MeliSocialApi.project.service.mapper;

import com.example.MeliSocialApi.project.model.Product;
import com.example.MeliSocialApi.project.model.ProductDetails;
import com.example.MeliSocialApi.project.model.ProductPromo;
import com.example.MeliSocialApi.project.model.User;
import com.example.MeliSocialApi.project.service.dto.ProductDTO;
import com.example.MeliSocialApi.project.service.dto.ProductDetailDTO;
import com.example.MeliSocialApi.project.service.dto.ProductPromoCountDTOResponse;
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
        return new Product(product.getUserId(),product.getIdPost(),product.getDate(),details,product.getCategory(),product.getPrice(),product.getHasPromo(),product.getDiscount());
    }
    public static ProductDTO productToProductDTO(Product product, ProductDetailDTO details){
        return new ProductDTO(product.getUserId(),product.getIdPost(),product.getDate(),details,product.getCategory(),product.getPrice(),product.getHasPromo(),product.getDiscount());
    }
    public static ProductUserDTOResponse productUserToDTO(User user, List<ProductDTO> posts){
        return new ProductUserDTOResponse(user.getId(),user.getName(),posts);
    }
    public static ProductPromoCountDTOResponse promoToProductPromoCount(User user, Integer productsPromoCount){
        return new ProductPromoCountDTOResponse(user.getId(),user.getName(),productsPromoCount);
    }
}