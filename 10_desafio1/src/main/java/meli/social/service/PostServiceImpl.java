package meli.social.service;

import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.model.UserModel;
import meli.social.repository.DataRepository;
import meli.social.service.dto.PostDTO;
import meli.social.service.dto.PostListUserDTO;
import meli.social.service.dto.UserDTO;
import meli.social.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void addPost(PostModel post) throws UserIdNotFoundException {
        int userId = post.getUserId();
        dataRepository.findUserById(userId);
        dataRepository.savePostDb(post);
    }

    @Override
    public List<PostListUserDTO> getPostsOfFollowed(int userId) throws UserIdNotFoundException {
        UserModel user = dataRepository.findUserById(userId);
        List<PostListUserDTO> postsListOfFollowed = new ArrayList<>();
        //List<UserDTO> followers = new ArrayList<>();
        for (int i = 0; i < user.getFollowed().size(); i++) {
            postsListOfFollowed.add(getPostsById(user.getFollowed().get(i)));
        }
        return postsListOfFollowed;
    }

    // ------------------------------ UTILS ------------------------------

    public PostListUserDTO getPostsById(int userId) {
        // 1) Traigo todos los posts
        List<PostModel> allPosts = dataRepository.getPostsDb();
        // 2) Creo la lista a devolver
        PostListUserDTO postsUser = new PostListUserDTO();
        // 3) Seteo el usuario a la lista
        postsUser.setUserId(userId);
        // 4) Creo un array para setear en los posts
        List<PostDTO> postsFound = new ArrayList<>();
        // 5) Recorro todos los posteos y lo voy agregando a la lista
        for (PostModel post: allPosts) {
            if(post.getUserId() == userId) {
                postsFound.add(PostMapper.toPostDTO(post));
            }
        }
        postsUser.setPosts(postsFound);
        return postsUser;
    }
}
