package com.example.socialmeli.services;

import com.example.socialmeli.dtos.post.PostListDTO;
import com.example.socialmeli.dtos.post.PromoCountDTO;
import com.example.socialmeli.dtos.user.MerchantDTO;
import com.example.socialmeli.dtos.user.SimpleMerchantDTO;
import com.example.socialmeli.exceptions.MerchantNotFoundException;
import com.example.socialmeli.exceptions.UserNotFoundException;
import com.example.socialmeli.exceptions.postExceptions.PostAlreadyExistException;
import com.example.socialmeli.models.Post;
import com.example.socialmeli.repositories.IPostRepository;
import com.example.socialmeli.repositories.ISocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService implements IPostService{
    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private ISocialRepository socialRepository;

    /**
     *
     * @param post
     * @return status 200.OK if the post was created successfully
     * @throws PostAlreadyExistException
     * @throws UserNotFoundException
     */
    @Override
    public HttpStatus newPost(Post post) throws PostAlreadyExistException, UserNotFoundException {
        // validate body post integration
        if (!isValidPost(post)){
            return HttpStatus.BAD_REQUEST;
        }

        // check if user exist (be user or merchant)
        if(socialRepository.getUserById(post.getUserId())==null && socialRepository.getMerchantById(post.getUserId())==null){
            throw new UserNotFoundException("The user id does not exist", HttpStatus.BAD_REQUEST);
        }

        // check if postid already exist
        if(postRepository.getPostById(post.getIdPost())!=null){
            throw new PostAlreadyExistException("The id of the post already exist",HttpStatus.BAD_REQUEST);
        }

        postRepository.newPost(post);
        return HttpStatus.CREATED;
    }

    /**
     *
     * @param userId
     * @param name
     * @param order
     * @return PostListDTO with the list of post did it by all the merchants that the users follow in the last 2 weeks
     * @throws UserNotFoundException
     */
    @Override
    public PostListDTO getPostByUserId(Integer userId, String name, String order) throws UserNotFoundException {
        // get list of merchants that the user follow
        List<SimpleMerchantDTO> followed = socialRepository.followedByMe(userId,name).getFollowers();

        SimpleMerchantDTO simple = followed.get(0);

        List<Post> postList;
        List<Post> finalPostList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate now = LocalDate.now();

        for (int i = 0; i < followed.size(); i++) {
            postList = postRepository.getPostByUserId(followed.get(i).getId(),order);

            for (int j = 0; j < postList.size(); j++) {
                // if the date of postList is between the last 2 weeks add to final list
                LocalDate postDate = postList.get(j).getDate();

                long days = ChronoUnit.DAYS.between(postDate, now);

                if (days < 14)
                    finalPostList.add(postList.get(j));
            }
        }

        PostListDTO response = new PostListDTO();
        response.setUserId(userId);
        response.setUserName(simple.getName());
        response.setPosts(finalPostList);

        return response;
    }

    /**
     *
     * @param userId
     * @return PromoCountDTO with the count of promos that the merchant did
     * @throws MerchantNotFoundException
     */
    @Override
    public PromoCountDTO promoCount(Integer userId) throws MerchantNotFoundException {
        MerchantDTO merchantDTO = socialRepository.getMerchantById(userId);

        if (merchantDTO == null){
            throw new MerchantNotFoundException("The merchantId does not exist",HttpStatus.BAD_REQUEST);
        }

        Integer promoCount = postRepository.promoCount(userId);
        return new PromoCountDTO(merchantDTO.getId(),merchantDTO.getName(),promoCount);
    }

    /**
     *
     * @param userId
     * @return PostListDTO with the list of post that the merchant did that have promo
     * @throws MerchantNotFoundException
     */
    @Override
    public PostListDTO listPromoProductsByUserid(Integer userId) throws MerchantNotFoundException {
        MerchantDTO merchantDTO = socialRepository.getMerchantById(userId);

        if (merchantDTO == null){
            throw new MerchantNotFoundException("The merchantId does not exist",HttpStatus.BAD_REQUEST);
        }

        List<Post> postList = postRepository.listPromoProductsByUserid(userId);

        return new PostListDTO(merchantDTO.getId(), merchantDTO.getName(),postList);
    }

    /**
     *
     * @param post
     * @return boolean if the post have correct date and details of product
     */
    private boolean isValidPost(Post post){
        if (post.getDate() == null || post.getDetail() == null){
            return false;
        }else{
            return true;
        }
    }

}
