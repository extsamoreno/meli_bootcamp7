package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.UserListPostDTO;
import com.meli.socialmeli.model.exception.IdNotFoundException;
import com.meli.socialmeli.model.exception.NonSellerUserException;
import com.meli.socialmeli.model.exception.PostIdAlreadyExistingException;
import com.meli.socialmeli.model.service.ServiceSocialMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ServiceSocialMeli serviceSocialMeli;

    @PostMapping("/newpost")
    public String createNewPOst(@RequestBody Post post) throws PostIdAlreadyExistingException,
            NonSellerUserException, IdNotFoundException {
        serviceSocialMeli.createNewPost(post); // el dato Date no esta recibiendo segun lo indicado por lor equerimientos tecnicos, se debe produndisar en cómo solucionar.
        return "OK";
    }

    @GetMapping("/followed/{userId}/list")
    public UserListPostDTO getListofPostbyUser(@PathVariable int userId) throws IdNotFoundException {
        return serviceSocialMeli.getListPostbyUser(userId);
    }
}
