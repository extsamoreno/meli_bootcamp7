package com.example.socialmeli.services;

import com.example.socialmeli.dtos.PostListDTO;
import com.example.socialmeli.dtos.SimpleMerchantDTO;
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

    @Override
    public PostListDTO getPostByUserId(Integer userId) throws UserNotFoundException {
        // get list of merchants that the user follow
        List<SimpleMerchantDTO> followed = socialRepository.followedByMe(userId,"").getFollowers();
        List<Post> postList;
        List<Post> finalPostList = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate now = LocalDate.now();

        for (int i = 0; i < followed.size(); i++) {
            postList = postRepository.getPostByUserId(followed.get(i).getId());

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
        response.setPosts(finalPostList);

        return response;
    }

    //region private methods
    private boolean isValidPost(Post post){
        if (post.getDate() == null || post.getProduct() == null){
            return false;
        }else{
            return true;
        }
    }

}
