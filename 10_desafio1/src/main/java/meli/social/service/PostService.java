package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.service.dto.PostListUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;


public interface PostService {
    List<PostModel> getAllPosts();
    void addPost(PostModel post) throws UserIdNotFoundException;
    List<PostListUserDTO> getPostsOfFollowed(int userId) throws UserIdNotFoundException;
}
