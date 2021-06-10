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

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;


    @Override
    public void addPost(Post post) throws Exception {
        if (postRepository.postExists(post)) {
            throw new NotFoundException("this post already exists");
        }
        postRepository.addPost(post);
    }

    @Override
    public ResponseGetPostsFollowedDTO getPostsFollowed(int userId, String order) throws NotFoundException {
        User user = userRepository.getById(userId);
        if (user == null) {
            throw new NotFoundException("User not exist");
        }
        List<User> sellerFollowed = userRepository.getSellersFollowedByUser(user);
        List<Post> filteredList = postRepository.getPostOfLasWeek(sellerFollowed);

        return new ResponseGetPostsFollowedDTO(
                userId,
                Mappers.toPostDTO(sortByCriteria(filteredList, order == null ? "date_desc" : order)));
    }

    @Override
    public ResponseCountPromosDTO promosByUser(int userId) throws NotFoundException {
        User user = userRepository.getById(userId);
        return new ResponseCountPromosDTO(
                user.getUserId(),
                user.getUserName(),
                postRepository.getCountPromosByUser(userId)
        );
    }

    @Override
    public ResponseListPromosDTO listPromosByUser(int userId) throws NotFoundException {
        User user = userRepository.getById(userId);
        return new ResponseListPromosDTO(
                user.getUserId(),
                user.getUserName(),
                Mappers.toPostPromoDTO(postRepository.getListPromosByUser(userId))
        );
    }

    private List<Post> sortByCriteria(List<Post> list, String order) {

        if (order.equals("date_desc")) {
            list.sort(Comparator.comparing(Post::getDate).reversed());
        } else {
            list.sort(Comparator.comparing(Post::getDate));
        }
        return list;
    }
}
