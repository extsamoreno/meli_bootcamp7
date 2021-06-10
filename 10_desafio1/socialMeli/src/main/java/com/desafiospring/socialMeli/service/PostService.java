package com.desafiospring.socialMeli.service;

import com.desafiospring.socialMeli.dto.*;
import com.desafiospring.socialMeli.dto.request.NewPostDTO;
import com.desafiospring.socialMeli.dto.request.NewPromoPostDTO;
import com.desafiospring.socialMeli.dto.response.FollowedPostDTO;
import com.desafiospring.socialMeli.dto.response.PromoPostCountDTO;
import com.desafiospring.socialMeli.dto.response.PromoPostListDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;

import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;
import com.desafiospring.socialMeli.repository.IPostRepository;
import com.desafiospring.socialMeli.repository.IUserRepository;
import com.desafiospring.socialMeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postRepository;

    @Override
    public void newPost(NewPostDTO post) throws UserNotFoundException, PostIdAlreadyExistException {
        userRepository.findUserById(post.getUserId());
        postRepository.addNewPost(PostMapper.toPost(post));
    }

    @Override
    public FollowedPostDTO getFollowedRecentPosts(int userId, String order) throws UserNotFoundException {

        User user = userRepository.findUserById(userId);
        List<User> usersFollowed = userRepository.getFollowedList(userId);
        List<Post> postList = postRepository.getFollowedPosts(usersFollowed);

        List<PostDTO> postDTOList = PostMapper.toDtoList(postList);

        sortByDate(postDTOList, order);

        return new FollowedPostDTO(user.getUserId(), postDTOList);
    }

    @Override
    public void newPromoPost(NewPromoPostDTO promoPost) throws UserNotFoundException, PostIdAlreadyExistException {
        userRepository.findUserById(promoPost.getUserId());
        postRepository.addNewPost(PostMapper.toPromoPost(promoPost));
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(int userId) throws UserNotFoundException {
        User user = userRepository.findUserById(userId);
        int count = postRepository.getPromoProductsCount(userId);
        return new PromoPostCountDTO(userId, user.getUserName(), count);
    }

    @Override
    public PromoPostListDTO getPromoPostsList(int userId) throws UserNotFoundException {
        User user = userRepository.findUserById(userId);
        List<Post> promoList = postRepository.getPromoPostsList(userId);
        List<PostDTO> dtoList = PostMapper.toDtoList(promoList);

        return new PromoPostListDTO(userId, user.getUserName(), dtoList);
    }

    private void sortByDate (List<PostDTO> list, String order) {
        if (order != null && order.equals("date_asc"))
            list.sort(Comparator.comparing(PostDTO::getDate));

        if (order != null && order.equals("date_desc"))
            list.sort(Comparator.comparing(PostDTO::getDate).reversed());
    }

}
