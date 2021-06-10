package com.example.desafiospring.socialmeli.service;

import com.example.desafiospring.socialmeli.exception.UserNotFoundException;
import com.example.desafiospring.socialmeli.model.Post;
import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.repository.IUserRepository;
import com.example.desafiospring.socialmeli.service.DTO.PostDTO;
import com.example.desafiospring.socialmeli.service.DTO.PostListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException {
        userRepository.insertPost(
                PostMapping.getPostDTO(post)
        );
    }
    @Override
    public PostListDTO getFollowedPostList(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<PostDTO> followedPostDTOList = new ArrayList<>();

        for (User userFollowed: user.getFollowed()
        ) {
            for (Post post: userFollowed.getPost()
            ) {
                followedPostDTOList.add(
                        PostMapping.getPostDTO(post)
                );
            }
        }

        Comparator<PostDTO> postDateComparator = Comparator.comparing(PostDTO::getDate);
        followedPostDTOList.sort(postDateComparator); //uso el comparador para sort la date

        return new PostListDTO(userId,followedPostDTOList);
    }

}
