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

    //US0005
    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostDTO postDTO) throws PostIdExistsException {
        iPostService.insertPost(postDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    //US0006 - US0009(order by date)
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsSellersFollowDTO> getPostsSellersFollow(@PathVariable() int userId, @RequestParam(required = false) String order)
            throws UserNotFoundException, PropertyNotFoundException {

        return new ResponseEntity<>(iPostService.getPostsSellersFollow(userId, order),HttpStatus.OK);
    }

    //US0010
    @PostMapping("/newpromopost")
    public ResponseEntity newPromoPost(@RequestBody PostDTO postDTO) throws PostIdExistsException {
        iPostService.insertPost(postDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    //US0011
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CountPromosDTO> countPromosByUser(@PathVariable() int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iPostService.countPromosByUser(userId), HttpStatus.OK);
    }

    //US0012
    @GetMapping("/{userId}/list")
    public ResponseEntity<ListPromosDTO> getPromosByUser(@PathVariable() int userId)
            throws UserNotFoundException {

        return new ResponseEntity<>(iPostService.getPromosByUser(userId),HttpStatus.OK);
    }



}


