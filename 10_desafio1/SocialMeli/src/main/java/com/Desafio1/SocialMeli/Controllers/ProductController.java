package com.Desafio1.SocialMeli.Controllers;

import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Services.IProductService;
import com.Desafio1.SocialMeli.Services.IUserService;
import com.Desafio1.SocialMeli.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    public ResponseEntity<?> createNewPost(@RequestBody Post post) throws DuplicateIdException, UserNotFoundException {
        iProductService.createNewPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
