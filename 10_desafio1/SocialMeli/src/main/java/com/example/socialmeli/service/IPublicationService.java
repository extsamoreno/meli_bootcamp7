package com.example.socialmeli.service;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;

import java.util.List;

public interface IPublicationService {
    PublicationCreateResponseDTO addPost(PublicationDTO post);
    List<PublicationCreateResponseDTO> addPost(List<PublicationDTO> post);
    List<PublicationDTO> getPosts();
}
