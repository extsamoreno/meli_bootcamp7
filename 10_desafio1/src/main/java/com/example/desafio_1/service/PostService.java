package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.models.Buyer;
import com.example.desafio_1.models.Post;
import com.example.desafio_1.models.User;
import com.example.desafio_1.repository.IPostRepository;
import com.example.desafio_1.service.dto.FollowedPostDTO;
import com.example.desafio_1.service.dto.PostDTO;
import com.example.desafio_1.service.dto.PostPromoDTO;
import com.example.desafio_1.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    IProductService productService;

    @Autowired
    IUserService userService;

    @Autowired
    IPostRepository postRepository;

    @Autowired
    PostMapper postMapper;

    @Override
    public void createPostByDTO(PostDTO postDTO) throws UserExceptionNotFound, UserExceptionWrongType, ProductExceptionNotFound, PostExceptionNotValid, ProductExceptionNotValid, PostExceptionNotExists, PostExceptionAlreadyExists {

        this.allValidationPostDTO(postDTO);

        Post post = postMapper.toModel(postDTO);

        createPost(post);
    }

    private void allValidationPostDTO(PostDTO postDTO) throws ProductExceptionNotValid, PostExceptionNotValid, ProductExceptionNotFound, UserExceptionNotFound, UserExceptionWrongType, PostExceptionAlreadyExists {
        //validate fields
        validateDTO(postDTO);

        productService.existsProduct(postDTO.getDetail().getProduct_id());

        //validate user
        userService.existsUser(postDTO.getUserId());

        userService.checkInstance(postDTO.getUserId(), "seller");

        if (this.existsPost(postDTO.getId_post())) {
            throw new PostExceptionAlreadyExists(postDTO.getId_post()); // cant create a post with the same id
        }
    }

    private void createPost(Post post) {
        postRepository.add(post);
    }

    @Override
    public FollowedPostDTO getFollowedUsersPostsByUserId(int userId, String order) throws UserExceptionNotFound, UserExceptionWrongType, WrongOrderFieldException {

        //Get user by id if not exists, throw exception
        User user = userService.getUserById(userId);

        //Check instance
        userService.checkInstance(user, "buyer");

        Buyer buyerCast = (Buyer) user;

        if (buyerCast.getFollowing().size() == 0) { //If nothing in the following list, return, maybe extract to method?
            return new FollowedPostDTO(user.getId(), new ArrayList<>());
        }

        List<Post> posts = getPostsFromFollowingBeforeTwoWeeks(buyerCast);

        if (!order.isEmpty()) {
            orderListOfPost(posts, order);
        }

        return new FollowedPostDTO(userId, posts.stream().map(x -> postMapper.toPostPromoDTO(x) ).collect(Collectors.toList()));
    }

    @Override
    public void createPostPromoByDTO(PostPromoDTO postPromoDTO) throws PostExceptionNotValid, UserExceptionWrongType, PostExceptionNotExists, ProductExceptionNotValid, ProductExceptionNotFound, PostExceptionAlreadyExists, UserExceptionNotFound {

        this.validateDTOPromo(postPromoDTO);

        this.allValidationPostDTO(postPromoDTO);

        Post post = postMapper.toModel(postPromoDTO);

        this.createPost(post);
    }

    private void orderListOfPost(List<Post> posts, String order) throws WrongOrderFieldException {
        if (order.equalsIgnoreCase("date_asc")) {
            posts.sort(Comparator.comparing(Post::getCreatedDate));
            return;
        }
        if (order.equalsIgnoreCase("date_desc")) {
            posts.sort(Collections.reverseOrder(Comparator.comparing(Post::getCreatedDate)));
            return;
        }
        if (!order.isEmpty()) { //if is not empty and the order criteria is not valid...
            throw new WrongOrderFieldException(order);
        }
    }

    private List<Post> getPostsFromFollowingBeforeTwoWeeks(Buyer buyerCast) {
        //Get all of the following ids
        int[] idsFollowing = Utils.getAllKeysFromFollowing(buyerCast.getFollowing());

        //Obtengo todos los posts con esos id's
        List<Post> posts = new ArrayList<>();

        for (int i : idsFollowing) {
            posts.addAll(postRepository.getAllPostsBeforeTwoWeeksFromSellerId(i));
        }
        return posts;
    }

    public boolean existsPost(int postId) {
        return postRepository.getById(postId) != null;
    }

    private void validateDTO(PostDTO postDTO) throws ProductExceptionNotValid, PostExceptionNotValid {
        //Only capture the valdiation for post, because in the product service process the productException, not here
        try {
            Utils.validateIntGreaterThanZero(postDTO.getUserId(), "userId");
            Utils.validateIntGreaterThanZero(postDTO.getCategory(), "category");
            Utils.validateDoubleGreaterThanZero(postDTO.getPrice(), "price");
            Utils.validateDate(postDTO.getDate(), "date");

        } catch (Exception e) {
            throw new PostExceptionNotValid(e.getMessage());
        }

        productService.validateDTO(postDTO.getDetail());
    }

    private void validateDTOPromo(PostPromoDTO postDTO) throws PostExceptionNotValid {
        try {
            Utils.validateBooleanMustBeTrue(postDTO.isHasPromo(), "hasPromo");
            Utils.validateDoubleGreaterThanZero(postDTO.getDiscount(), "discount");
            Utils.validateDoubleGreaterThanValue(postDTO.getDiscount(), postDTO.getPrice(), "discount", "price");
            Utils.validateDoubleEqualsToValue(postDTO.getDiscount(), postDTO.getPrice(), "discount", "price");
        }
        catch (Exception e) {
            throw new PostExceptionNotValid(e.getMessage());
        }
    }

}
