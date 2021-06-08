package com.example.demo.project.service.mapper;

import com.example.demo.project.models.Product;
import com.example.demo.project.models.Publication;
import com.example.demo.project.models.User;
import com.example.demo.project.service.dto.ProductDTO;
import com.example.demo.project.service.dto.PublicationDTO;
import com.example.demo.project.service.dto.UserDTO;
import com.example.demo.project.service.dto.UserWithFollowingCountDTO;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapper {
    public Publication toPublication(PublicationDTO publicationDTO){
        return new Publication(publicationDTO.getId_post(), publicationDTO.getId_user(), publicationDTO.getDate(), toProduct(publicationDTO.getDetail()), publicationDTO.getCategory(), publicationDTO.getPrice());
    }

    public Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProductName(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }
}
