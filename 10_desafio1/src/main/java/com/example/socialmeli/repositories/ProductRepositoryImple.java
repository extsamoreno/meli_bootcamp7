package com.example.socialmeli.repositories;

import com.example.socialmeli.exceptions.ExistentPostException;
import com.example.socialmeli.exceptions.ExistentPromoPostException;
import com.example.socialmeli.exceptions.InexistentUserException;
import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.PostDTO;
import com.example.socialmeli.models.dtos.UserDTO;
import com.example.socialmeli.models.dtos.request.NewPromoPostRequestDTO;
import com.example.socialmeli.models.dtos.response.ListFollowedPostsResponseDTO;
import com.example.socialmeli.models.dtos.response.ListSellerPromoProductsDTO;
import com.example.socialmeli.models.dtos.response.NewPostResponseDTO;
import com.example.socialmeli.models.dtos.response.SellerPromoProductsCountResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class ProductRepositoryImple implements ProductRepository{

    @Autowired
    UserRepository userRepository;

    @Override
    public void addPost(PostDTO newPostRequestDTO) throws InexistentUserException, ExistentPostException {
        User user = userRepository.getUserById(newPostRequestDTO.getUserId());
        PostDTO post = new PostDTO();
        NewPostResponseDTO newPost = new NewPostResponseDTO();

        for (int i = 0; i < user.getPosts().size(); i++) {
            PostDTO sellerPost = user.getPosts().get(i);

            if(sellerPost.getPostId() == newPostRequestDTO.getPostId()){
                throw new ExistentPostException(sellerPost.getPostId());
            }
        }

        post.setPostId(newPostRequestDTO.getPostId());
        post.setUserId(user.getUserId());
        post.setDetail(newPostRequestDTO.getDetail());
        post.setCategory(newPostRequestDTO.getCategory());
        post.setDate(newPostRequestDTO.getDate());
        post.setPrice(newPostRequestDTO.getPrice());

        user.addPost(post);

        newPost.setPostId(newPostRequestDTO.getPostId());
        newPost.setUserId(user.getUserId());
    }

    @Override
    public ListFollowedPostsResponseDTO listPosts(int idUser) throws InexistentUserException{
        User user = userRepository.getUserById(idUser);
        ListFollowedPostsResponseDTO posts = new ListFollowedPostsResponseDTO();
        ArrayList<PostDTO> userPostsPastTwoWeeks = new ArrayList<>();
        LocalDate todayDate = LocalDate.now();
        LocalDate pastTwoWeeksDate = todayDate.minusWeeks(2);

        for (int i = 0; i < user.getFollowed().size(); i++) {
            UserDTO followedSellerDTO = user.getFollowed().get(i);
            User followedSeller = userRepository.getUserById(followedSellerDTO.getUserId());

            for (int j = 0; j < followedSeller.getPosts().size(); j++) {
                PostDTO post = followedSeller.getPosts().get(j);
                LocalDate postDate = post.getDate();

                if(postDate.isBefore(todayDate) && postDate.isAfter(pastTwoWeeksDate)){
                    userPostsPastTwoWeeks.add(post);
                }
            }
        }

        posts.setUserId(idUser);
        posts.setPosts(userPostsPastTwoWeeks);

        return posts;
    }

    @Override
    public void addPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws InexistentUserException, ExistentPromoPostException {
        User user = userRepository.getUserById(newPromoPostRequestDTO.getUserId());
        PostDTO post = new PostDTO();

        for (int i = 0; i < user.getPosts().size(); i++) {
            PostDTO sellerPromoPost = user.getPosts().get(i);

            if(sellerPromoPost.getPostId() == newPromoPostRequestDTO.getPostId()){
                throw new ExistentPromoPostException(sellerPromoPost.getPostId());
            }
        }

        post.setPostId(newPromoPostRequestDTO.getPostId());
        post.setUserId(newPromoPostRequestDTO.getUserId());
        post.setDate(newPromoPostRequestDTO.getDate());
        post.setDetail(newPromoPostRequestDTO.getDetail());
        post.setCategory(newPromoPostRequestDTO.getCategory());
        post.setPrice(newPromoPostRequestDTO.getPrice());
        post.setHasPromo(newPromoPostRequestDTO.isHasPromo());
        post.setDiscount(newPromoPostRequestDTO.getDiscount());

        user.addPost(post);
    }

    @Override
    public SellerPromoProductsCountResponseDTO countPromoProducts(int userId) throws InexistentUserException {
        User user = userRepository.getUserById(userId);
        SellerPromoProductsCountResponseDTO promoProducts = new SellerPromoProductsCountResponseDTO();
        int promoProductsCount = 0;

        for (int i = 0; i < user.getPosts().size(); i++) {
            PostDTO post = user.getPosts().get(i);

            if(post.isHasPromo()){
                promoProductsCount++;
            }
        }

        promoProducts.setUserId(userId);
        promoProducts.setUserName(user.getUserName());
        promoProducts.setPromoProductsCount(promoProductsCount);

        return promoProducts;
    }

    @Override
    public ListSellerPromoProductsDTO listPromoProducts(int userId) throws InexistentUserException {
        User user = userRepository.getUserById(userId);
        ListSellerPromoProductsDTO promoProducts = new ListSellerPromoProductsDTO();
        ArrayList<PostDTO> promoPosts = new ArrayList<>();

        for (int i = 0; i < user.getPosts().size(); i++) {
            PostDTO post = user.getPosts().get(i);

            if(post.isHasPromo()){
                promoPosts.add(post);
            }
        }


        promoProducts.setUserId(userId);
        promoProducts.setUserName(user.getUserName());
        promoProducts.setPosts(promoPosts);

        return promoProducts;
    }


}
