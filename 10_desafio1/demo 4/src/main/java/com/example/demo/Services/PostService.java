package com.example.demo.Services;

import com.example.demo.Entities.Post;
import com.example.demo.Entities.User;
import com.example.demo.Exceptions.BadRequestException;
import com.example.demo.Exceptions.NotFoundException;
import com.example.demo.Repository.*;
import com.example.demo.Services.DTO.PostDTO;
import com.example.demo.Services.DTO.ResponseGetPostsFollowedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;


    public void addPost(Post post) throws Exception {
        postRepository.loadPost();
        if (postRepository.postExists(post)) {
            throw new NotFoundException("this post already exists");
        }
        postRepository.addPost(post);
    }

    public ResponseGetPostsFollowedDTO getPostsFollowed(int userId , String order) throws Exception {
        userRepository.loadUsers();
        postRepository.loadPost();

        User user = userRepository.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not exist");
        }
        List<User> sellerFollowed = userRepository.getSellersFollowedByUser(user);
        List<PostDTO> filteredList = postRepository.getPostOfLasWeek(sellerFollowed, order == null ? "date_desc" : order);

        return new ResponseGetPostsFollowedDTO(userId, filteredList);
    }
}
