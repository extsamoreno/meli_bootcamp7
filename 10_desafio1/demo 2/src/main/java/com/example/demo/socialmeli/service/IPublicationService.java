package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.repository.Publication;
import com.example.demo.socialmeli.service.dto.PublicationListDTO;
import com.example.demo.socialmeli.service.dto.PublicationRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public interface IPublicationService {
    void addNewPost (PublicationRequestDTO publicationRequestDTO);
    PublicationListDTO getPublicationList (int id);

}
