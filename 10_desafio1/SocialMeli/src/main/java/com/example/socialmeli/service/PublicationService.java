package com.example.socialmeli.service;

import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationFollowedUserResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationPromoCreateResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.mapper.PublicationMapper;
import com.example.socialmeli.model.Publication;
import com.example.socialmeli.repository.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PublicationService implements IPublicationService {

    @Autowired
    IPublicationRepository iPublicationRepository;
    @Autowired
    PublicationMapper publicationMapper;
    @Autowired
    IUserService iUserService;


    @Override
    public PublicationCreateResponseDTO addPublication(PublicationDTO obj) {
        return new PublicationCreateResponseDTO(publicationMapper.toPublicationDTO(iPublicationRepository.addPublication(publicationMapper.toPublication(obj))));
    }

    @Override
    public PublicationPromoCreateResponseDTO addPublication(PublicationPromoDTO publication) {
        return new PublicationPromoCreateResponseDTO(publicationMapper.toPublicationPromoDTO(iPublicationRepository.addPublication(publicationMapper.toPublication(publication))));
    }

    @Override
    public List<PublicationCreateResponseDTO> addPublication(List<PublicationDTO> post) {
        List<PublicationCreateResponseDTO> response = new ArrayList<>();
        for (PublicationDTO obj : post) {
            response.add(addPublication(obj));
        }
        return response;
    }

    @Override
    public List<PublicationDTO> getPublications() {
        List<PublicationDTO> response = new ArrayList<>();
        for (Publication obj : iPublicationRepository.getPublications()) {
            response.add(publicationMapper.toPublicationDTO(obj));
        }
        return response;
    }

    @Override
    public List<PublicationPromoDTO> getPublicationsPromo(int userId) {
        List<PublicationPromoDTO> response = new ArrayList<>();
        for (Publication obj : iPublicationRepository.getPublicationsPromo()) {
            if (obj.getUserId() == userId)
                response.add(publicationMapper.toPublicationPromoDTO(obj));
        }
        return response;
    }

    @Override
    public List<PublicationPromoDTO> getPublicationsPromo() {
        List<PublicationPromoDTO> response = new ArrayList<>();
        for (Publication obj : iPublicationRepository.getPublicationsPromo()) {
            response.add(publicationMapper.toPublicationPromoDTO(obj));
        }
        return response;
    }

    @Override
    public List<PublicationDTO> getPublicationsByUserId(int userId) {
        List<PublicationDTO> response = new ArrayList<>();
        for (Publication obj : iPublicationRepository.getPublications()) {
            response.add(publicationMapper.toPublicationDTO(obj));
        }
        return response;
    }

    @Override
    public PublicationFollowedUserResponseDTO getPublicationFollowedUser(int userId, String order) {
        UserFolLisResponseDTO users = iUserService.getFollowedList(userId, null);
        PublicationFollowedUserResponseDTO response = new PublicationFollowedUserResponseDTO();
        UserDTO user = new UserDTO();
        user.setUserId(users.getUserId());
        user.setUserName(users.getUserName());
        response.setUser(user);
        List<PublicationDTO> publication = new ArrayList<>();
        for (UserDTO obj : users.getFollowed()) {
            publication.addAll(getPublicationsByUserId(obj.getUserId()));
        }
        publication.sort(Comparator.comparing(PublicationDTO::getDate));
        if (order != null) {
            if (order.equals("date_asc")) {
                publication.sort(Comparator.comparing(PublicationDTO::getDate));
            }
            if (order.equals("date_desc")) {
                publication.sort(Comparator.comparing(PublicationDTO::getDate).reversed());
            }
        }
        Calendar ca = new GregorianCalendar();
        ca.setTime(new Date());
        ca.add(Calendar.WEEK_OF_MONTH, -2);
        response.setPosts(publication.stream().filter(x -> x.getDate().after(ca.getTime())).collect(Collectors.toList()));


        return response;
    }
}
