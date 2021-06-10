package com.bootcamp.socialmeli.controller;

import com.bootcamp.socialmeli.DTO.request.PostPromoDTOreq;
import com.bootcamp.socialmeli.DTO.response.CountPromoProductsDTO;
import com.bootcamp.socialmeli.DTO.response.ListOfPostsDTOres;
import com.bootcamp.socialmeli.DTO.request.PostDTOreq;
import com.bootcamp.socialmeli.DTO.response.ListOfPostsWithUsernameDTOres;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class PostController {

    @Autowired
    IPostService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PostDTOreq post)
            throws UserIdNotFoundException, PostAlreadyRegisteredException {

        productService.newPost(post);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ListOfPostsDTOres> getFollowedPosts(
            @PathVariable Integer userId, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        return new ResponseEntity<>(productService.getFollowedPost(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<Void> newPromoPost(@Valid @RequestBody PostPromoDTOreq post)
            throws UserIdNotFoundException, PostAlreadyRegisteredException {

        productService.newPost(post);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromoProductsDTO> getCountPromoProducts(@PathVariable Integer userId)
            throws UserIdNotFoundException {
        return new ResponseEntity<>(productService.getCountPromoProducts(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<ListOfPostsWithUsernameDTOres> getListPromoProducts(@PathVariable Integer userId)
            throws UserIdNotFoundException {
        return new ResponseEntity<>(productService.getListPromoProducts(userId), HttpStatus.OK);
    }
}
