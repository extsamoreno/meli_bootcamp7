package meli.social.controller;

import meli.social.exception.PostIdRepeatedException;
import meli.social.exception.UserIdNotFoundException;
import meli.social.model.PostModel;
import meli.social.model.UserModel;
import meli.social.service.PostService;
import meli.social.service.dto.PostListUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/products")

public class PostController {

    @Autowired
    PostService postService;

    // ------------------------- ENDPOINTS PARA VERIFICAR SEEDS -------------------------
    @GetMapping()
    public List<PostModel> allPosts (){
        return postService.getAllPosts();
    }

    // ------------------------------ ENDPOINTS FUNCIONALES ------------------------------

    @PostMapping("/newpost")
    public HttpStatus newPost (@RequestBody PostModel post) throws UserIdNotFoundException {
        postService.addPost(post);
        return HttpStatus.OK;
    }

    @GetMapping("/followed/{userId}/list")
    public PostListUserDTO
    postsOfFollowed (@PathVariable int userId, @RequestParam (defaultValue = "date_desc") String order)
            throws UserIdNotFoundException, ParseException {
        return postService.getPostsOfFollowed(userId, order);
    }

}
