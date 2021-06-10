package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.PostCollectionDTO;
import com.meli.socialmeli.dto.PostDTO;
import com.meli.socialmeli.dto.PromoPostsDTO;
import com.meli.socialmeli.dto.UserDTO;
import com.meli.socialmeli.exception.InvalidIdException;
import com.meli.socialmeli.exception.PostIdAlreadyExistsException;
import com.meli.socialmeli.mapper.PostMapper;
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

    private static final String DATE_ASC = "date_asc";
    private static final String NAME_ASC = "name_asc";

    /**
     * Inserts a new post (this post can be promo or standard)
     *
     * @param postDTO The Post that want to be persisted
     * @throws InvalidIdException           If the userId entered does not correspond to an existing user
     * @throws PostIdAlreadyExistsException If the entered postId already exists
     */
    public void insertNewPost(PostDTO postDTO) throws InvalidIdException, PostIdAlreadyExistsException {

        if (userRepository.userIdIsNotValid(postDTO.getUserId())) {
            throw new InvalidIdException();
        }

        if (postRepository.postIdAlreadyExists(postDTO.getPostId())) {
            throw new PostIdAlreadyExistsException();
        }

        postRepository.insertNewPost(postDTO.getPostId(), mapToPost(postDTO));
    }

    /**
     * Obtains all the posts published in the last 2 weeks by the sellers to which the entered user follows
     *
     * @param userId Corresponding to the user from whom you want to obtain the posts of his followed sellers
     * @param order  The chronological order in which you want to obtain the results. This order can be ascending or descending
     * @return The posts published in the last 2 weeks by the sellers to which the entered user follows, with the userId and userName of each seller
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    public List<PostCollectionDTO> getFollowedMerchantsPosts(int userId, String order) throws InvalidIdException {

        List<PostCollectionDTO> postCollectionDTOList = new ArrayList<>();

        List<UserDTO> followedList = userService.getFollowedList(userId, NAME_ASC).getFollowed();

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


    /**
     * Obtains the number of promotional posts that a user has
     *
     * @param userId Corresponding to the user from whom you want to obtain the count of promotional posts
     * @return The count of promotional posts that a user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    public PromoPostsDTO getMerchantNumberOfPromoPosts(int userId) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        PromoPostsDTO promoPostsDTO = new PromoPostsDTO();

        promoPostsDTO.setUserId(userId);
        promoPostsDTO.setPromoProductsCount(postRepository.getNumberOfPostsById(userId));
        promoPostsDTO.setUserName(userRepository.getUserById(userId).getUserName());

        return promoPostsDTO;
    }

    /**
     * Obtains the list of the promotional posts that a user has
     *
     * @param userId Corresponding to the user from whom you want to obtain the promotional posts
     * @return A list of the promotional posts that a user has
     * @throws InvalidIdException If the userId entered does not correspond to an existing user
     */
    public PostCollectionDTO getMerchantPromoPosts(int userId) throws InvalidIdException {

        if (userRepository.userIdIsNotValid(userId)) {
            throw new InvalidIdException();
        }

        PostCollectionDTO merchantPromoPosts = new PostCollectionDTO();
        List<PostDTO> postDTOList = new ArrayList<>();

        Map<Integer, Post> promoPosts = postRepository.getPromoPostsById(userId);

        for (Map.Entry<Integer, Post> entry : promoPosts.entrySet()) {
            postDTOList.add(PostMapper.mapToPostDTO(entry.getKey(), entry.getValue()));
        }

        merchantPromoPosts.setUserId(userId);
        merchantPromoPosts.setUserName(userRepository.getUserById(userId).getUserName());
        merchantPromoPosts.setPosts(sortPosts(postDTOList, DATE_ASC));

        return merchantPromoPosts;
    }

}


