package com.example.socialmeli.service;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationFollowedUserResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationPromoCreateResponseDTO;

import java.text.ParseException;
import java.util.List;

public interface IPublicationService {
    PublicationCreateResponseDTO addPublication(PublicationDTO publication);
    PublicationPromoCreateResponseDTO addPublication(PublicationPromoDTO publication);

    List<PublicationCreateResponseDTO> addPublication(List<PublicationDTO> publication);

    List<PublicationDTO> getPublications() ;
    List<PublicationPromoDTO> getPublicationsPromo(int userId);
    List<PublicationPromoDTO> getPublicationsPromo();

    List<PublicationDTO> getPublicationsByUserId(int userId) ;

    PublicationFollowedUserResponseDTO getPublicationFollowedUser(int userId,String order);
}
