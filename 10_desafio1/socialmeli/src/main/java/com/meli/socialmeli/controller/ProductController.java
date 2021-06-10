package com.meli.socialmeli.controller;

import com.meli.socialmeli.model.dao.model.Post;
import com.meli.socialmeli.model.dto.UserListPostDTO;
import com.meli.socialmeli.model.dto.UserSellerCountPromoDTO;
import com.meli.socialmeli.model.dto.UserSellerListPromoDTO;
import com.meli.socialmeli.model.exception.*;
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
    public ResponseEntity<String> createNewPost(@RequestBody Post post)
            throws PostIdAlreadyExistingException, NonSellerUserException, IdNotFoundException {
        serviceSocialMeli.createNewPost(post); //
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserListPostDTO> getListofPostbyUser(@PathVariable int userId,
                                                               @RequestParam(name = "order",
                                                                       required = false,
                                                                       defaultValue = "date_desc") String order)
            throws IdNotFoundException, ErrorOrderParamDateException, SellerCanNotFollowException {
        return new ResponseEntity<>(serviceSocialMeli.getListPostbyUser(userId, order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> createNewPromoPost(@RequestBody Post post)
            throws PostIdAlreadyExistingException, NonSellerUserException, IdNotFoundException {
        serviceSocialMeli.createNewPost(post);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<UserSellerCountPromoDTO> getCountPromoByUserSeller(@PathVariable int userId)
            throws NonSellerUserException, IdNotFoundException {
        return new ResponseEntity<>(serviceSocialMeli.getUserSellerCountPromoDTO(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<UserSellerListPromoDTO> getListromoByUserSeller(@PathVariable int userId)
            throws NonSellerUserException, IdNotFoundException {
        return new ResponseEntity<>(serviceSocialMeli.getUserSellerListPromoDTO(userId), HttpStatus.OK);
    }

}
