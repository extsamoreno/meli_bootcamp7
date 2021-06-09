package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.PostCollectionDTO;
import com.meli.socialmeli.dto.PostDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.PostIdAlreadyExistsException;
import com.meli.socialmeli.models.Post;
import com.meli.socialmeli.repository.PostRepository;
import com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.meli.socialmeli.mapper.PostMapper.mapToPost;
import static com.meli.socialmeli.mapper.PostMapper.mapToPostDTO;
import static com.meli.socialmeli.util.ProductUtil.sortPosts;
import static com.meli.socialmeli.util.ProductUtil.toLocalDate;

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

    public List<PostCollectionDTO> getFollowedMerchantsPosts(int userId, String order) throws InvalidIdException {

        List<PostCollectionDTO> postCollectionDTOList = new ArrayList<>();

        List<UserDTO> followedList = userService.getFollowedList(userId, "name_asc").getFollowed();

        for (UserDTO eachFollowedMerchant : followedList) {

            PostCollectionDTO eachMerchantPostCollectionDTO = new PostCollectionDTO();
            List<PostDTO> merchantPostsDTO = new ArrayList<>();
            Map<Integer, Post> merchantPostsRepository = postRepository.getPostsByMerchantId(eachFollowedMerchant.getUserId());

            for (Map.Entry<Integer, Post> entry : merchantPostsRepository.entrySet()) {

                // NOTE: To get the results of the last 14 days, it is necessary to use minusDays(16) by parsing with data type "Date"
                LocalDate last2Weeks = LocalDate.now().minusDays(16);

                if (toLocalDate(entry.getValue().getDate()).isAfter(last2Weeks)) {

                    PostDTO eachPost = mapToPostDTO(entry.getKey(), entry.getValue());
                    merchantPostsDTO.add(eachPost);
                }
            }
            eachMerchantPostCollectionDTO.setUserId(eachFollowedMerchant.getUserId());
            eachMerchantPostCollectionDTO.setPosts(sortPosts(merchantPostsDTO, order));

            postCollectionDTOList.add(eachMerchantPostCollectionDTO);
        }
        return postCollectionDTOList;
    }

}


