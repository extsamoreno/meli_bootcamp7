package com.example.socialmeli.service;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationFollowedUserResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationPromoCountResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationPromoCreateResponseDTO;
import com.example.socialmeli.exceptions.UserIdNotFountException;

import java.util.List;

public interface IPublicationService {
    //Add publication in list memory
    PublicationCreateResponseDTO addPublication(PublicationDTO publication);

    //Add publication promo in list memory
    PublicationPromoCreateResponseDTO addPublication(PublicationPromoDTO publication);

    //Add lost publications in list memory
    List<PublicationCreateResponseDTO> addPublication(List<PublicationDTO> publication);

    //get all publication
    List<PublicationDTO> getPublications();

    //get count publication promo user by userId
    PublicationPromoCountResponseDTO getPublicationsPromoCount(int userId);

    //get all publication promo user by userId
    List<PublicationPromoDTO> getPublicationsPromo(int userId);

    //get all publication promo
    List<PublicationPromoDTO> getPublicationsPromo();

    //get publication user by userId
    List<PublicationDTO> getPublicationsByUserId(int userId);

    //get all publication from user followed by userId  --  order asc-desc
    PublicationFollowedUserResponseDTO getPublicationFollowedUser(int userId, String order) throws UserIdNotFountException;
}
