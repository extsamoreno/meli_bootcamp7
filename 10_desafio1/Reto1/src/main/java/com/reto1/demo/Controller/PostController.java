package com.reto1.demo.Controller;

import com.reto1.demo.Exception.OrderNotFoundException;
import com.reto1.demo.Exception.PostException.DateNotExistException;
import com.reto1.demo.Exception.PostException.DuplicatedPostException;
import com.reto1.demo.Exception.UserException.UserIdNotFoundException;
import com.reto1.demo.Exception.UserException.UserNotFollowException;
import com.reto1.demo.Model.DTO.PostObjects.LastPostDTO;
import com.reto1.demo.Model.DTO.PostObjects.PromoPostCount;
import com.reto1.demo.Model.DTO.UserObjets.UserPromoPostListDTO;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.PromoPost;
import com.reto1.demo.Service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {

    @Autowired
    IPostService iPostService;

    /**
     * Create a post
     */
    @PostMapping("/products/newpost")
    public ResponseEntity<String> createPost(@RequestBody Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException {
        String postname = iPostService.creatPost(post);
        return new ResponseEntity<>("The post " + postname + " was created", HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @param order
     * @return LastPostDTO (Recent posts and promo post order default asc)
     * @throws UserIdNotFoundException
     * @throws UserNotFollowException
     * @throws OrderNotFoundException
     */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<LastPostDTO> lastPosts(@PathVariable int userId,
                                                 @RequestParam(required = false, defaultValue = "date_desc") String order)
            throws UserIdNotFoundException, UserNotFollowException, OrderNotFoundException {
        return new ResponseEntity<>(iPostService.orderLastPost(userId, order), HttpStatus.OK);
    }

    /**
    * Create products
    */
    @PostMapping("/products/newpromopost")
    public ResponseEntity<String> createPromoPost(@RequestBody PromoPost post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException {
        String postname = iPostService.creatPost(post);
        return new ResponseEntity<>("The post " + postname + " was created", HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @return PromoPostCount count the promoposts user
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     */
    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<PromoPostCount> countPromoPost(@PathVariable int userId) throws UserNotFollowException, UserIdNotFoundException {
        return new ResponseEntity<>(iPostService.countPromoPost(userId),HttpStatus.OK);
    }

    /**
     *
     * @param userId
     * @return UserPromoPostListDTO get list alls promoposts user
     * @throws UserNotFollowException
     * @throws UserIdNotFoundException
     */
    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<UserPromoPostListDTO> listPromoPost(@PathVariable int userId) throws UserNotFollowException, UserIdNotFoundException {
        return new ResponseEntity<>(iPostService.listPromoPost(userId),HttpStatus.OK);
    }
}





