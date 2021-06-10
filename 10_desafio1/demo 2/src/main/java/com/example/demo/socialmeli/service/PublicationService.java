package com.example.demo.socialmeli.service;

import com.example.demo.socialmeli.repository.Publication;
import com.example.demo.socialmeli.repository.User;
import com.example.demo.socialmeli.repository.UserRepository;
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
    public void addNewPost(PublicationRequestDTO publicationRequestDTO) {
        int id = publicationRequestDTO.getUserId();
        User user = userRepository.getUserById(id);
        user.getPosts().add(publicationRequestDTO.getId_post());
        userRepository.refreshUser(user);
        Publication publication = new Publication();
        publication.setCategory(publicationRequestDTO.getCategory());
        publication.setId_post(publicationRequestDTO.getId_post());
        publication.setDate(publicationRequestDTO.getDate());
        publication.setDetail(publicationRequestDTO.getDetail());
        publication.setPrice(publicationRequestDTO.getPrice());
        userRepository.refreshPublications(publication);
    }

    @Override
    public PublicationListDTO getPublicationList(int id, String order) {
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
}
