package com.example.socialmeli.service;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;
import com.example.socialmeli.mapper.PublicationMapper;
import com.example.socialmeli.model.Publication;
import com.example.socialmeli.repository.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicationService implements IPublicationService {
    @Autowired
    IPublicationRepository iPostRepository;
    @Autowired
    PublicationMapper publicationMapper;

    @Override
    public PublicationCreateResponseDTO addPost(PublicationDTO post) {
        return new PublicationCreateResponseDTO(publicationMapper.toPostDTO(iPostRepository.addPost(publicationMapper.toPost(post))));
    }

    @Override
    public List<PublicationCreateResponseDTO> addPost(List<PublicationDTO> post) {
        List<PublicationCreateResponseDTO> response = new ArrayList<>();
        for (PublicationDTO obj : post) {
            response.add(addPost(obj));
        }
        return response;
    }

    @Override
    public List<PublicationDTO> getPosts() {
        List<PublicationDTO> response = new ArrayList<>();
        for (Publication obj : iPostRepository.getPosts()) {
            response.add(publicationMapper.toPostDTO(obj));
        }
        return response;
    }
}
