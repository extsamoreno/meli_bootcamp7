package com.example.demo.project.service;

import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.service.dto.PublicationDTO;

public interface IPublicationService {

    void newPost(PublicationDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException;
}
