package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;


public interface PostService {
    List<PostModel> getAllPosts();
    HttpStatus addPost(PostModel post) throws UserIdNotFoundException;
}
