package com.example.demo.services;

import com.example.demo.DTO.ResponseCountPromosDTO;
import com.example.demo.DTO.ResponseListPromosDTO;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.*;
import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.ResponseGetPostsFollowedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;


    public void addPost(Post post) throws Exception {
        if (postRepository.postExists(post)) {
            throw new NotFoundException("this post already exists");
        }
        postRepository.addPost(post);
    }

    public ResponseGetPostsFollowedDTO getPostsFollowed(int userId, String order) throws Exception {
        User user = userRepository.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not exist");
        }
        List<User> sellerFollowed = userRepository.getSellersFollowedByUser(user);
        List<PostDTO> filteredList = postRepository.getPostOfLasWeek(sellerFollowed, order == null ? "date_desc" : order);

        return new ResponseGetPostsFollowedDTO(userId, filteredList);
    }

    public ResponseCountPromosDTO promosByUser(int userId) {
        User user = userRepository.getById(userId);
        return new ResponseCountPromosDTO(
                user.getUserId(),
                user.getUserName(),
                postRepository.getCountPromosByUser(userId)
        );
    }

    public ResponseListPromosDTO listPromosByUser(int userId) {
        User user = userRepository.getById(userId);
        return new ResponseListPromosDTO(
                user.getUserId(),
                user.getUserName(),
                postRepository.getListPromosByUser(userId)
        );
    }

}
