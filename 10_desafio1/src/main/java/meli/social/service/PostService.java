package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.service.dto.PostListUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Hashtable;
import java.util.List;


public interface PostService {
    List<PostModel> getAllPosts();
    void addPost(PostModel post) throws UserIdNotFoundException;
    PostListUserDTO getPostsOfFollowed(int userId, String order) throws UserIdNotFoundException, ParseException;
}
