package com.example.demo.services;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PostListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.IGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServices implements IProductServices{

    @Autowired
    IGeneralRepository repository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException {
        repository.findById(post.getUserId());
        repository.newPost(post);
    }

    @Override
    public PostListDTO getPostList(Integer userId) {
        List<UserDTO> listFollowed= repository.followedList(userId);
        List<PostDTO> listPost = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -2);

        for (UserDTO user: listFollowed) {
            listPost = Stream.concat(listPost.stream(), repository.findPostByUserId(user.getUserId()).stream())
                    .filter(post -> post.getDate().after(calendar.getTime()))
                    .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                    .collect(Collectors.toList());
        }

        return new PostListDTO(userId,listPost);
    }
}
