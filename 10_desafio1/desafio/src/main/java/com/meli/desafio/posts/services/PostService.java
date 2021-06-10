package com.meli.desafio.posts.services;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.exceptions.PostNotPromoException;
import com.meli.desafio.posts.mappers.PostMapper;
import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.*;
import com.meli.desafio.posts.repositories.IPostRepository;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.mappers.UserMapper;
import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.UserDTO;
import com.meli.desafio.users.services.IUserService;
import com.meli.desafio.utils.ChallengeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{

    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserService userService;

    @Override
    public Integer addNewPost(PostDTO postDTO) throws PostErrorException {
        Post post = PostMapper.DtoToPost(postDTO);
        postRepository.save(post);
        return post.getPostId();
    }

    @Override
    public PostPromoDTO getById(Integer postId) throws PostNotExistException {
        return PostMapper.postToPromoDto(postRepository.getById(postId));
    }

    @Override
    public ResponseListPostsDto getPostList(Integer userId) throws UserNotFoundException {
        if(!userService.userExist(userId)) throw new UserNotFoundException(userId);
        return createlistPostDTO(postRepository.getAllByUserId(userId), userId);
    }

    @Override
    public List<ResponseListPostsDto> getPostListForUsersFollowed(Integer userId, String order) throws UserNotFoundException {
        List<ResponseListPostsDto> listPostsDtos = new ArrayList<>();
        List<Integer> listUsersIds = userService.getById(userId).getFollowed();
        List<UserDTO> listUsers = new ArrayList<>();

        for(Integer id : listUsersIds){
            listUsers.add(UserMapper.userToDTO(userService.getById(id)));
        }

        for(UserDTO u : listUsers){
            List<Post> listPosts = postRepository.getAllByUserId(u.getId());

            if(order.equalsIgnoreCase("date_desc")) {
                Collections.reverse(listPosts);
            }

            listPostsDtos.add(createlistPostDTO(listPosts, u.getId()));
        }

        return listPostsDtos;
    }

    @Override
    public Integer addNewPromoPot(PostPromoDTO postPromoDTO) throws PostErrorException, PostNotPromoException {
        if(!postPromoDTO.isHasPromo()){
            throw new PostNotPromoException();
        }
        Post post = PostMapper.promoDTOToPost(postPromoDTO);
        postRepository.save(post);
        return post.getPostId();
    }

    @Override
    public PromoCountDTO getCountPromos(Integer userId) throws UserNotFoundException {
        User user = userService.getById(userId);
        List<Post> list = postRepository.getAllPromosByUserId(userId);
        return PostMapper.postToCountDTO(user, list.size());
    }

    @Override
    public PostPromoListDTO getListPromos(Integer userId, String order) throws UserNotFoundException {
        User user = userService.getById(userId);
        List<Post> list = postRepository.getAllPromosByUserId(userId);

        if(order.equalsIgnoreCase("date_desc")) {
            Collections.reverse(list);
        }

        return PostMapper.postListToPromoListDTO(user, list);
    }

    private ResponseListPostsDto createlistPostDTO(List<Post> posts, Integer userId){
        return ResponseListPostsDto.builder()
                .userId(userId)
                .posts(PostMapper.postToDTOList(posts))
                .build();
    }
}
