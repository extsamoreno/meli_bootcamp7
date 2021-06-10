package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.exception.InvalidityDateException;
import com.example.demo.socialmeli.exception.MissingParameterException;
import com.example.demo.socialmeli.exception.PublicationExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.service.dto.CountPromoDTO;
import com.example.demo.socialmeli.service.dto.PublicationListDTO;
import com.example.demo.socialmeli.service.dto.PublicationRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface IPublicationService {
    void addNewPost (PublicationRequestDTO publicationRequestDTO) throws UserNotFoundException, PublicationExistingException, MissingParameterException, InvalidityDateException;
    PublicationListDTO getPublicationList (int id, String order) throws UserNotFoundException;
    CountPromoDTO countPromo (int userId) throws UserNotFoundException;
    int getCountPromo(int id) throws UserNotFoundException;
    PublicationListDTO getPublicationListPromo(int id, String order) throws UserNotFoundException;
}
