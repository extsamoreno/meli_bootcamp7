package com.example.demo.project.service;

import com.example.demo.project.exception.CantInsertDateGreaterThanToday;
import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.PublicationIsNotPromoException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.service.dto.PublicationDTO;
import com.example.demo.project.service.dto.FollowedPublicationsDTO;
import com.example.demo.project.service.dto.UserWithPromoPublicationCountDTO;

import java.util.Optional;

public interface IPublicationService {

    void newPost(PublicationDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException, PublicationIsNotPromoException, CantInsertDateGreaterThanToday;
    FollowedPublicationsDTO getFollowedPost(int user_id, Optional<String> order) throws UserIdNotFoundException;
    UserWithPromoPublicationCountDTO getPromoPublications(int userid) throws UserIdNotFoundException;
    FollowedPublicationsDTO getPromoPublications(int user_id, Optional<String> order) throws UserIdNotFoundException;
}
