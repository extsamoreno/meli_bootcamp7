package com.example.SocialMeli.Services.Mapper;



import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.ProductDTO;
import com.example.SocialMeli.Services.DTOs.UserDTO;

public class ProductMapper {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getName());
    }

    public static Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getType(), productDTO.getColor(), productDTO.getNotes());
    }
}
