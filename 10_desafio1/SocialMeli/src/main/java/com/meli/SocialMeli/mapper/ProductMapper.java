package com.meli.SocialMeli.mapper;

import com.meli.SocialMeli.dto.PostDto;
import com.meli.SocialMeli.dto.PostPromResDto;
import com.meli.SocialMeli.dto.PostResDto;
import com.meli.SocialMeli.dto.ProductDto;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductMapper {
    public static Post postDtoToPost(PostDto postDto) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(postDto.getDate());
        return new Post(-1,postDto.getUserId(),postDto.getId_post(),date,-1,postDto.getCategory(),postDto.getPrice());
    }

    public static Post postDtoToPromoPost(PostDto postDto) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(postDto.getDate());
        return new Post(-1,postDto.getUserId(),postDto.getId_post(),date,-1,postDto.getCategory(),postDto.getPrice(),postDto.isHasPromo(),postDto.getDiscount());
    }

    public static Product productDtoToProduct(ProductDto detail) {
        return new Product(-1,detail.getProduct_id(), detail.getProductName(), detail.getType(), detail.getBrand(), detail.getColor(), detail.getNotes());
    }

    public static PostResDto postToResDto(Post post, Product product) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(post.getDate());
        return new PostResDto(post.getId_post(),date,productToDto(product),post.getCategory(),post.getCategory());
    }

    public static PostPromResDto postToPromoResDto(Post post, Product product) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(post.getDate());
        return new PostPromResDto(post.getId_post(),date,productToDto(product),post.getCategory(),post.getCategory(),post.isHasPromo(),post.getDiscount());
    }

    private static ProductDto productToDto(Product product) {
        return new ProductDto(product.getProduct_id(), product.getProductName(),product.getType(), product.getBrand(),product.getColor(), product.getNotes());
    }
}
