package com.spring.desafioSpring.Controllers;

import com.spring.desafioSpring.DTOs.CountPromosDTO;
import com.spring.desafioSpring.DTOs.ListPromosDTO;
import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.DTOs.PostsSellersFollowDTO;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Exceptions.PropertyNotFoundException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService iPostService;

    /** US0005 - Allows to register a post
     * @param postDTO    json with info about the post
     * @return void      with SatusCode
     * @throws PostIdExistsException
     * @throws UserNotFoundException
     */
    @PostMapping("/newpost")
    public ResponseEntity<?> newPost(@RequestBody PostDTO postDTO) throws PostIdExistsException, UserNotFoundException {
        iPostService.insertPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** US0006 - US0009(order by date) - Returns a list of a user posts has
     * @param userId                   id of the user from whom such information is requested
     * @param order                    response list order
     * @return PostsSellersFollowDTO   contains id and list posts with products of a user has
     * @throws UserNotFoundException
     * @throws PropertyNotFoundException
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsSellersFollowDTO> getPostsSellersFollow(@PathVariable() int userId, @RequestParam(required = false) String order)
            throws UserNotFoundException, PropertyNotFoundException {

        return new ResponseEntity<>(iPostService.getPostsSellersFollow(userId, order),HttpStatus.OK);
    }

    /** US0010 - Allows to register a post with promotion
     * @param postDTO     json with info about the post
     * @return  void      with SatusCode
     * @throws PostIdExistsException
     * @throws UserNotFoundException
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<?> newPromoPost(@RequestBody PostDTO postDTO) throws PostIdExistsException, UserNotFoundException {
        iPostService.insertPost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** US0011 - Returns the number of posts with promotion a user has
     * @param userId            id of the user from whom such information is requested
     * @return CountPromosDTO   contains id, name and number of posts with promotion of a user
     * @throws UserNotFoundException
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromosDTO> countPromosByUser(@PathVariable() int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iPostService.countPromosByUser(userId), HttpStatus.OK);
    }

    /** US0012 - Returns a list of a user posts with promotion has
     * @param userId            id of the user from whom such information is requested
     * @return ListPromosDTO    contains id, name and list posts with promotions of a user has
     * @throws UserNotFoundException
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<ListPromosDTO> getPromosByUser(@PathVariable() int userId)
            throws UserNotFoundException {

        return new ResponseEntity<>(iPostService.getPromosByUser(userId),HttpStatus.OK);
    }



}


