package com.example.demo.project.service;

import com.example.demo.project.exception.CantInsertDateGreaterThanToday;
import com.example.demo.project.exception.DuplicatedPublicationIdException;
import com.example.demo.project.exception.PublicationIsNotPromoException;
import com.example.demo.project.exception.UserIdNotFoundException;
import com.example.demo.project.models.Publication;
import com.example.demo.project.models.User;
import com.example.demo.project.repository.IDataRepository;
import com.example.demo.project.service.dto.*;
import com.example.demo.project.service.mapper.PublicationMapper;
import com.example.demo.project.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class PublicationService implements IPublicationService{

    @Autowired
    IDataRepository iDataRepository;

    @Autowired
    PublicationMapper publicationMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void newPost(PublicationDTO publicationDTO) throws DuplicatedPublicationIdException, UserIdNotFoundException, PublicationIsNotPromoException, CantInsertDateGreaterThanToday {
        if (publicationDTO.getDate().isAfter(LocalDate.now()))
            throw new CantInsertDateGreaterThanToday(publicationDTO.getDate());

        if (publicationDTO instanceof PublicationPromoDTO && (((PublicationPromoDTO) publicationDTO).getHasPromo() == null || ((PublicationPromoDTO) publicationDTO).getHasPromo() == false))
            throw new PublicationIsNotPromoException();

        Publication publication = publicationMapper.toPublication(publicationDTO);
        iDataRepository.addPublication(publication);
    }

    @Override
    public FollowedPublicationsDTO getFollowedPost(int userid, Optional<String> order) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        if (user == null) throw new UserIdNotFoundException(userid);

        List<Publication> publications = iDataRepository.getFollowedPublications(user.getFollowing());

        UserDTO userDTO = userMapper.toUserDTO(user);
        FollowedPublicationsDTO pubDTO = publicationMapper.toFollowedPublicationsDTO(userDTO, publications);

        if (order.isPresent()) orderPublicationList(pubDTO.getPublicationsDTO(), order.get());
        return pubDTO;
    }


    @Override
    public UserWithPromoPublicationCountDTO getPromoPublications(int userid) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        if (user == null) throw new UserIdNotFoundException(userid);

        List<Publication> publications = iDataRepository.getPromoPublications(user.getPublications());


        return userMapper.toUserWithPromoPublicationsDTO(user, publications.size());
    }

    @Override
    public FollowedPublicationsDTO getPromoPublications(int userid, Optional<String> order) throws UserIdNotFoundException {
        User user = iDataRepository.getUserById(userid);
        if (user == null) throw new UserIdNotFoundException(userid);

        List<Publication> publications = iDataRepository.getPromoPublications(user.getPublications());

        UserDTO userDTO = userMapper.toUserDTO(user);
        FollowedPublicationsDTO pubDTO = publicationMapper.toFollowedPublicationsDTO(userDTO, publications);

        if (order.isPresent()) orderPublicationList(pubDTO.getPublicationsDTO(), order.get());
        return pubDTO;
    }


    private void orderPublicationList(List<PublicationDTO> publicationList, String order) {
        switch (order) {
            case "date_asc":
                Comparator<PublicationDTO> publicationDateComparator = Comparator.comparing(PublicationDTO::getDate);
                publicationList.sort(publicationDateComparator);
                break;
            case "date_desc":
                Comparator<PublicationDTO> publicationDateComparatorRev = Comparator.comparing(PublicationDTO::getDate).reversed();
                publicationList.sort(publicationDateComparatorRev);
                break;
            case "name_asc":
                Comparator<PublicationDTO> publicationNameComparator = Comparator.comparing(p -> p.getDetail().getProductName().toUpperCase());
                publicationList.sort(publicationNameComparator);
                break;
            case "name_desc":
                Comparator<PublicationDTO> publicationNameComparatorRev = Comparator.comparing(p -> p.getDetail().getProductName().toUpperCase());
                publicationList.sort(publicationNameComparatorRev.reversed());
                break;
            default:
                break;
        }
    }
}
