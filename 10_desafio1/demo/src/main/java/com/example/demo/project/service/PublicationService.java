package com.example.demo.project.service;

import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.models.Publication;
import com.example.demo.project.repository.IDataRepository;
import com.example.demo.project.service.dto.PublicationDTO;
import com.example.demo.project.service.mapper.PublicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService implements IPublicationService{

    @Autowired
    IDataRepository iDataRepository;

    @Autowired
    PublicationMapper publicationMapper;

    @Override
    public void newPost(PublicationDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException {
        Publication publication = publicationMapper.toPublication(publicationDTO);
        iDataRepository.addPublication(publication);
    }
}
