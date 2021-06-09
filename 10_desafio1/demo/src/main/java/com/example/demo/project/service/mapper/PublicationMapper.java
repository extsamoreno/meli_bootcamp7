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
        if (publicationDTO instanceof PublicationPromoDTO) return new Publication(publicationDTO.getId_post(), publicationDTO.getId_user(), publicationDTO.getDate(), toProduct(publicationDTO.getDetail()), publicationDTO.getCategory(), publicationDTO.getPrice(), ((PublicationPromoDTO) publicationDTO).getHasPromo(), ((PublicationPromoDTO) publicationDTO).getDiscount());
        return new Publication(publicationDTO.getId_post(), publicationDTO.getId_user(), publicationDTO.getDate(), toProduct(publicationDTO.getDetail()), publicationDTO.getCategory(), publicationDTO.getPrice(), false, 0);
    }

    public Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getProduct_id(), productDTO.getProductName(), productDTO.getType(), productDTO.getBrand(), productDTO.getColor(), productDTO.getNotes());
    }

    public PublicationDTO toPublicationDTO(Publication publication) {
        if (publication.getHasPromo()) return new PublicationPromoDTO(publication.getId_post(), publication.getId_user(), publication.getDate(), toProductDTO(publication.getDetail()), publication.getCategory(), publication.getPrice(), publication.getHasPromo(), publication.getDiscount());
        return new PublicationDTO(publication.getId_post(), publication.getId_user(), publication.getDate(), toProductDTO(publication.getDetail()), publication.getCategory(), publication.getPrice());
    }

    public ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getProduct_id(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
    }

    public FollowedPublicationsDTO toFollowedPublicationsDTO(UserDTO userDTO, List<Publication> publicationList) {
        List<PublicationDTO> publicationDTOList = publicationList.stream().map(publication -> toPublicationDTO(publication)).collect(Collectors.toList());
        return new FollowedPublicationsDTO(userDTO, publicationDTOList);
    }
}
