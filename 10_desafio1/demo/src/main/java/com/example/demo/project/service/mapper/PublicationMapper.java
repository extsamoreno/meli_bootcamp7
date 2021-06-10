package com.example.demo.project.service.mapper;

import com.example.demo.project.models.Product;
import com.example.demo.project.models.Publication;
import com.example.demo.project.service.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublicationMapper {
    public Publication toPublication(PublicationDTO publicationDTO) {
        if (publicationDTO instanceof PublicationPromoDTO) return new Publication(publicationDTO.getPost_id(), publicationDTO.getUser_id(), publicationDTO.getDate(), toProduct(publicationDTO.getDetail()), publicationDTO.getCategory(), publicationDTO.getPrice(), ((PublicationPromoDTO) publicationDTO).getHas_promo(), ((PublicationPromoDTO) publicationDTO).getDiscount());
        return new Publication(publicationDTO.getPost_id(), publicationDTO.getUser_id(), publicationDTO.getDate(), toProduct(publicationDTO.getDetail()), publicationDTO.getCategory(), publicationDTO.getPrice(), false, 0);
    }

    public Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProduct_name(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }

    public PublicationDTO toPublicationDTO(Publication publication) {
        return new PublicationPromoDTO(publication.getPost_id(), publication.getUser_id(), publication.getDate(), toProductDTO(publication.getDetail()), publication.getCategory(), publication.getPrice(), publication.getHas_promo(), publication.getDiscount());
    }

    public ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getProduct_id(), product.getProduct_name(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    public FollowedPublicationsDTO toFollowedPublicationsDTO(UserDTO userDTO, List<Publication> publicationList) {
        List<PublicationDTO> publicationDTOList = publicationList.stream().map(publication -> toPublicationDTO(publication)).collect(Collectors.toList());
        return new FollowedPublicationsDTO(userDTO, publicationDTOList);
    }
}
