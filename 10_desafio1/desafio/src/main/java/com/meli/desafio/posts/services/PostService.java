package com.meli.desafio.posts.services;

import com.meli.desafio.posts.exceptions.PostErrorException;
import com.meli.desafio.posts.exceptions.PostNotExistException;
import com.meli.desafio.posts.mappers.PostMapper;
import com.meli.desafio.posts.models.Post;
import com.meli.desafio.posts.models.dto.PostDTO;
import com.meli.desafio.posts.models.dto.ResponseListPostsDto;
import com.meli.desafio.posts.repositories.IPostRepository;
import com.meli.desafio.users.exceptions.UserNotFoundException;
import com.meli.desafio.users.models.dto.UserDTO;
import com.meli.desafio.users.services.IUserService;
import com.meli.desafio.utils.SortUtil;
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
    public PostDTO getById(Integer postId) throws PostNotExistException {
        return PostMapper.postToDto(postRepository.getById(postId));
    }

    @Override
    public ResponseListPostsDto getPostList(Integer userId) throws UserNotFoundException {
        if(!userService.userExist(userId)) throw new UserNotFoundException(userId);
        return createlistPostDTO(postRepository.getAllByUserId(userId), userId);
    }

    @Override
    public List<ResponseListPostsDto> getPostListForUsersFollowed(Integer userId, String order) throws UserNotFoundException {
        List<ResponseListPostsDto> listPostsDtos = new ArrayList<>();
        List<UserDTO> listUsers = userService.getById(userId).getFollowed();

        for(UserDTO u : listUsers){
            List<Post> listPosts = postRepository.getAllByUserId(userId)
                    .stream().filter(p -> p.getDate().after(getDateBeforeTwoWeeks())).collect(Collectors.toList());
            Collections.sort(listPosts);
            if(order.equalsIgnoreCase("date_desc"))
                Collections.reverse(listPosts);
            listPostsDtos.add(createlistPostDTO(listPosts, u.getId()));
        }

        return listPostsDtos;
    }

    private Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }

    private ResponseListPostsDto createlistPostDTO(List<Post> posts, Integer userId){
        return ResponseListPostsDto.builder()
                .userId(userId)
                .posts(PostMapper.postToDTOList(posts))
                .build();
    }
}
