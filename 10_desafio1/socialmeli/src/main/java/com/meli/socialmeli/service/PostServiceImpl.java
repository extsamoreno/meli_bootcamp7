package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.SocialExceptionUserNotExists;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.PostDTO;
import com.meli.socialmeli.service.dto.PostFollowingDTO;
import com.meli.socialmeli.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void addPost(PostDTO post) {
        postRepository.addPost(PostMapper.DTOToModel(post));
    }

    @Override
    public List<PostDTO> getListPostByUserId(int userId) {
        List<Post> postList = postRepository.getListPostByUserId(userId);
        return postList.stream().map(PostMapper::modelToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> getListPromoPostByUserId(int userId) {
        List<Post> postList = postRepository.getListPromoPostByUserId(userId);
        return postList.stream().map(PostMapper::modelToDTO).collect(Collectors.toList());
    }

    @Override
    public PostFollowingDTO getListPostUsersFollowingByUserId(int userId, String order) throws SocialExceptionUserNotExists {
        userService.userExists(userId);
        List<Integer> followings = userRepository.getFollowingByUserId(userId);
        List<PostDTO> postsListFollowingUsers = new ArrayList<>();
        followings.forEach(e -> postsListFollowingUsers.addAll(getListPostByUserId(e)
                .stream()
                .filter(x -> LocalDate.parse(x.getDate(),formatter).isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList())
        ));
        if (order !=null && order.compareTo("desc") > 0) {
            postsListFollowingUsers.sort((a, b) -> LocalDate.parse(a.getDate(),formatter).compareTo(LocalDate.parse(b.getDate(),formatter)));
        } else {
            postsListFollowingUsers.sort((a, b) -> LocalDate.parse(b.getDate(),formatter).compareTo(LocalDate.parse(a.getDate(),formatter)));
        }
        return new PostFollowingDTO(userId, postsListFollowingUsers);
    }

    @Override
    public PostFollowingDTO getListPromoPostUsersFollowingByUserId(int userId, String order) throws SocialExceptionUserNotExists {
        userService.userExists(userId);
        List<Integer> followings = userRepository.getFollowingByUserId(userId);
        List<PostDTO> postsListFollowingUsers = new ArrayList<>();
        followings.forEach(e -> postsListFollowingUsers.addAll(getListPromoPostByUserId(e)
                .stream()
                .filter(x -> LocalDate.parse(x.getDate()).isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList())
        ));
        if (order !=null && order.compareTo("desc") > 0) {
            postsListFollowingUsers.sort((a, b) -> LocalDate.parse(a.getDate(),formatter).compareTo(LocalDate.parse(b.getDate(),formatter)));
        } else {
            postsListFollowingUsers.sort((a, b) -> LocalDate.parse(b.getDate(),formatter).compareTo(LocalDate.parse(a.getDate(),formatter)));
        }

        return new PostFollowingDTO(userId, postsListFollowingUsers);
    }

}
