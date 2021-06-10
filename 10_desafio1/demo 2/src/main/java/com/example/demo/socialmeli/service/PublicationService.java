package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.exception.InvalidityDateException;
import com.example.demo.socialmeli.exception.MissingParameterException;
import com.example.demo.socialmeli.exception.PublicationExistingException;
import com.example.demo.socialmeli.exception.UserNotFoundException;
import com.example.demo.socialmeli.models.Publication;
import com.example.demo.socialmeli.models.User;
import com.example.demo.socialmeli.repository.UserRepository;
import com.example.demo.socialmeli.service.dto.CountFollowersDTO;
import com.example.demo.socialmeli.service.dto.CountPromoDTO;
import com.example.demo.socialmeli.service.dto.PublicationListDTO;
import com.example.demo.socialmeli.service.dto.PublicationRequestDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PublicationService implements IPublicationService {
    private final UserRepository userRepository;

    public PublicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addNewPost(PublicationRequestDTO publicationRequestDTO) throws UserNotFoundException,PublicationExistingException,MissingParameterException, InvalidityDateException
    {
        int id = publicationRequestDTO.getUserId();
        User user = userRepository.getUserById(id);
        List<Publication> publications = userRepository.getAllPublication();
        for (int i=0;i<publications.size();i++) {
            if (publications.get(i).getId_post() == publicationRequestDTO.getId_post())
                throw new PublicationExistingException(publicationRequestDTO.getId_post());
        }
        user.getPosts().add(publicationRequestDTO.getId_post());
        userRepository.refreshUser(user);
        Publication publication = new Publication();
        if (publicationRequestDTO.getCategory()<=0)
            throw new MissingParameterException("category");
        publication.setCategory(publicationRequestDTO.getCategory());
        if (publicationRequestDTO.getId_post()<=0)
            throw new MissingParameterException("id_post");
        publication.setId_post(publicationRequestDTO.getId_post());
        if (publicationRequestDTO.getDate()==null)
            throw new MissingParameterException("date");
        Calendar dateCalendar = Calendar.getInstance();
        Date todaysDate = dateCalendar.getTime();
        if (publicationRequestDTO.getDate().after(todaysDate))
            throw new InvalidityDateException(publicationRequestDTO.getDate());
        publication.setDate(publicationRequestDTO.getDate());
        if (publicationRequestDTO.getDetail()==null)
            throw new MissingParameterException("detail");
        publication.setDetail(publicationRequestDTO.getDetail());
        if (publicationRequestDTO.getPrice()<=0)
            throw new MissingParameterException("price");
        publication.setPrice(publicationRequestDTO.getPrice());
        publication.setHasPromo(publicationRequestDTO.isHasPromo());
        if (publicationRequestDTO.getDiscount()>1)
            throw new MissingParameterException("discount");
        publication.setDiscount(publicationRequestDTO.getDiscount());
        userRepository.refreshPublications(publication);
    }

    @Override
    public PublicationListDTO getPublicationList(int id, String order) throws UserNotFoundException {
        User user = userRepository.getUserById(id);
        List<Publication> publications = userRepository.getAllPublication();
        ArrayList<Publication> arrayList = new ArrayList<>();
        for (int i = 0; i < user.getPosts().size(); i++) {
            int idPost = user.getPosts().get(i);
            Optional<Publication> item = publications.stream().filter(publication -> publication.getId_post() == idPost).findFirst();
            if (item.isPresent()) {
                arrayList.add(item.get());
            }
        }
        PublicationListDTO publicationListDTO = new PublicationListDTO();
        publicationListDTO.setUserId(id);
        arrayList.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_YEAR, -14);
        Date finallyDate = date.getTime();
        ArrayList<Publication> arrayList1 = new ArrayList<>();
        for (int k = 0; k < arrayList.size(); k++) {
            if (finallyDate.before(arrayList.get(k).getDate())) {
                arrayList1.add(arrayList.get(k));
            }
        }
        if (order != null) {
            if (order.equals("date_asc"))
                arrayList1.sort((a, b) -> a.getDate().compareTo(b.getDate()));
            else if (order.equals("date_desc"))
                arrayList1.sort((a, b) -> b.getDate().compareTo(a.getDate()));
        }
        publicationListDTO.setPosts(arrayList1);
        return publicationListDTO;
    }
    @Override
    public CountPromoDTO countPromo (int userId) throws UserNotFoundException{
        User user = userRepository.getUserById(userId);
        CountPromoDTO countPromoDTO = new CountPromoDTO();
        countPromoDTO.setUserId(user.getUserId());
        countPromoDTO.setUserName(user.getUserName());
        countPromoDTO.setPromoproducts_count(this.getCountPromo(userId));
        return countPromoDTO;
    }
    @Override
    public int getCountPromo(int id) throws UserNotFoundException {
        PublicationListDTO publicationListDTOS = this.getPublicationList(id,null);
        int count=0;
        for (int i=0;i<publicationListDTOS.getPosts().size();i++) {
            if (publicationListDTOS.getPosts().get(i).isHasPromo())
                count++;
        }
        return count;
    }
}
