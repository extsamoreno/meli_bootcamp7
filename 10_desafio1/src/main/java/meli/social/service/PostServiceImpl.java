package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    DataRepository dataRepository;

    @Override
    public List<PostModel> getAllPosts() {
        return dataRepository.getPostsDb();
    }

    @Override
    public HttpStatus addPost(PostModel post) throws UserIdNotFoundException {
        int userId = post.getUserId();
        dataRepository.findUserById(userId);
        dataRepository.savePostDb(post);
        return HttpStatus.OK;
    }

}
