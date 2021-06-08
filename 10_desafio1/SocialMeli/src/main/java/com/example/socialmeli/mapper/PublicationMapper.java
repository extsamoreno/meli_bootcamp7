package com.example.socialmeli.mapper;


import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicationMapper {
    @Autowired
    ProductMapper productMapper;
    public PublicationDTO toPostDTO (Publication obj){
        PublicationDTO response= new PublicationDTO();
        response.setId_post(obj.getId_post());
        response.setUserId(obj.getUserId());
        response.setDate(obj.getDate());
        response.setDetail(productMapper.toProductDTO(obj.getDetail()));
        response.setCategory(obj.getCategory());
        response.setPrice(obj.getPrice());
        response.setHasPromo(obj.isHasPromo());
        response.setDiscount(obj.getDiscount());
        return response;
    }
    public Publication toPost (PublicationDTO obj){
        Publication response= new Publication();
        response.setId_post(obj.getId_post());
        response.setUserId(obj.getUserId());
        response.setDate(obj.getDate());
        response.setDetail(productMapper.toProduct(obj.getDetail()));
        response.setCategory(obj.getCategory());
        response.setPrice(obj.getPrice());
        response.setHasPromo(obj.isHasPromo());
        response.setDiscount(obj.getDiscount());
        return response;
    }
}
