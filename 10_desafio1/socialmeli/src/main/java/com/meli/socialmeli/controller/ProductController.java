package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.UserListPostDTO;
import com.meli.socialmeli.model.exception.ErrorOrderParamDateException;
import com.meli.socialmeli.model.exception.IdNotFoundException;
import com.meli.socialmeli.model.exception.NonSellerUserException;
import com.meli.socialmeli.model.exception.PostIdAlreadyExistingException;
import com.meli.socialmeli.model.service.ServiceSocialMeli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ServiceSocialMeli serviceSocialMeli;

    @PostMapping("/newpost")
    public ResponseEntity<String> createNewPOst(@RequestBody Post post) throws PostIdAlreadyExistingException,
            NonSellerUserException, IdNotFoundException {
        serviceSocialMeli.createNewPost(post); //
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserListPostDTO> getListofPostbyUser(@PathVariable int userId, @RequestParam(name = "order",
            required = false, defaultValue = "date_desc") String order) throws IdNotFoundException,
            ErrorOrderParamDateException {
        return new ResponseEntity<>(serviceSocialMeli.getListPostbyUser(userId, order), HttpStatus.OK);
    }
}
