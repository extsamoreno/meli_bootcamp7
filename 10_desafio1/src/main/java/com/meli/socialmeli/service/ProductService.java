package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.PostCollectionDTO;
import com.meli.socialmeli.dto.PostDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.PostIdAlreadyExistsException;
import com.meli.socialmeli.mapper.PostMapper;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.repository.PostRepository;
import com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.meli.socialmeli.mapper.PostMapper.mapToPost;
import static com.meli.socialmeli.mapper.PostMapper.mapToPostDTO;

@Service
public class ProductService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public void insertNewPost(PostDTO postDTO) throws InvalidIdException, PostIdAlreadyExistsException {

        if (userRepository.userIdIsNotValid(postDTO.getUserId())) {
            throw new InvalidIdException();
        }

        if (postRepository.postIdAlreadyExists(postDTO.getIdPost())) {
            throw new PostIdAlreadyExistsException();
        }

        postRepository.insertNewPost(postDTO.getIdPost(), mapToPost(postDTO));
    }

    public List<PostCollectionDTO> getFollowedMerchantsPosts(int userId) throws InvalidIdException {

        List<PostCollectionDTO> postCollectionDTOList = new ArrayList<>();

        List<UserDTO> followedList = userService.getFollowedList(userId).getFollowed();

        for (UserDTO eachFollowedMerchant : followedList) {

            PostCollectionDTO merchantPostCollectionDTO = new PostCollectionDTO();
            List<PostDTO> merchantPostsDTO = new ArrayList<>();
            Map<Integer, Post> merchantPostsRepository = postRepository.getPostsByMerchantId(eachFollowedMerchant.getUserId());

            for (Map.Entry<Integer, Post> entry : merchantPostsRepository.entrySet()) {

                PostDTO eachPost = mapToPostDTO(entry.getKey(), entry.getValue());
                merchantPostsDTO.add(eachPost);
            }
            merchantPostCollectionDTO.setUserId(eachFollowedMerchant.getUserId());
            merchantPostCollectionDTO.setPosts(merchantPostsDTO);

            postCollectionDTOList.add(merchantPostCollectionDTO);
        }
        return postCollectionDTOList;
    }
}


