package com.example.desafio1.services;

import com.example.desafio1.dtos.PostDTO;
import com.example.desafio1.dtos.ResponseFollowedPostDTO;
import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.exceptions.InvalidUserIdException;
import com.example.desafio1.mappers.PostMapper;
import com.example.desafio1.models.Post;
import com.example.desafio1.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserService iUserService;

    @Override
    public String addNewPost(PostDTO postDTO) throws InvalidUserIdException {
        return iProductRepository.addNewPost(postDTO.getUserId(), PostMapper.DTOToPost(postDTO),
                iUserService.getUserById(postDTO.getUserId()));
    }

    @Override
    public ResponseFollowedPostDTO getAllPostOfMyFollowed(int userId) throws InvalidUserIdException {
        List<UserDTO> followed = iUserService.getFollowedList(userId);
        List<Post> posts = new ArrayList<>();
        List<Post> temp = new ArrayList<>();
        for(UserDTO u : followed) {
            temp.addAll(iUserService.getPostsList(u.getUserId()));
        }
        LocalDate now = LocalDate.now();
        long daysBetween;
        for(Post p : temp) {
            daysBetween = ChronoUnit.DAYS.between(p.getDate(), now);
            if(daysBetween <= 14) {
                posts.add(p);
            }
        }
        Comparator<Post> comparator = (a,b)->b.getDate().compareTo(a.getDate());
        posts.sort(comparator);
        ResponseFollowedPostDTO responseFollowedPostDTO = new ResponseFollowedPostDTO();
        responseFollowedPostDTO.setUserId(userId);
        responseFollowedPostDTO.setPosts(posts);
        return responseFollowedPostDTO;
    }
}
