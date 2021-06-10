package com.springChallenge.api.service.implementation;

import com.springChallenge.api.controller.dto.product.CountPromoDTO;
import com.springChallenge.api.controller.dto.product.PostDTO;
import com.springChallenge.api.controller.dto.product.PostsListDTO;
import com.springChallenge.api.controller.exception.product.IDPostAlreadyUsed;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.repository.entity.Post;
import com.springChallenge.api.repository.entity.User;
import com.springChallenge.api.service.contract.IProductService;
import com.springChallenge.api.service.mapper.product.CountPromoMapper;
import com.springChallenge.api.service.mapper.product.PostMapper;
import com.springChallenge.api.service.mapper.product.PostsListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class ProductService implements IProductService {
    @Autowired
    IUserRepository iUserRepository;

    /**
     * create a new post and add it to an user
     * @param postDTO
     * @throws UserNotFoundException
     * @throws IDPostAlreadyUsed
     */
    @Override
    public void createNewPost(PostDTO postDTO) throws UserNotFoundException, IDPostAlreadyUsed {
        var post = PostMapper.toEntity(postDTO);
        addPostToUser(post);
    }

    /**
     * search for the user given his id and add the post
     * @param post
     * @throws UserNotFoundException
     * @throws IDPostAlreadyUsed
     */
    private void addPostToUser(Post post) throws UserNotFoundException, IDPostAlreadyUsed {
        var user = iUserRepository.getByUserId(post.getUserId());
        user.addPost(post);
        iUserRepository.save(user);
    }

    /**
     * Gets all the posts by sellers followed by an user given his id, can order by post Date
     * @param userId
     * @param order
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public PostsListDTO getPostsByFollowed(Integer userId, String order) throws UserNotFoundException {
        ArrayList<Post> posts = iUserRepository.getFollowedPosts(userId);
        if (!order.isEmpty())
            orderList(posts, order);
        return PostsListMapper.toDTO(userId, posts);
    }

    /**
     * returns the promo posts total by an user given his id
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public CountPromoDTO getCountPromo(Integer userId) throws UserNotFoundException {
        User user = iUserRepository.getByUserId(userId);
        var promoPostsCount = user.getPosts().stream().filter(Post::isHasPromo).count();
        return CountPromoMapper.toCountPromoDTO(user, (int) promoPostsCount);
    }

    /**
     * gets all the posts that includes promo (hasPromo == true)
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public PostsListDTO getPromoPostsById(Integer userId) throws UserNotFoundException {
        ArrayList<Post> posts = iUserRepository.getPromoPostsById(userId);
        return PostsListMapper.toDTO(userId, posts);
    }

    /**
     * order posts by postDate
     * @param posts
     * @param order
     */
    private void orderList(ArrayList<Post> posts, String order) {
        if (order.equals("date_asc")) {
            Collections.sort(posts);
        } else {
            posts.sort(Collections.reverseOrder());
        }
    }
}
