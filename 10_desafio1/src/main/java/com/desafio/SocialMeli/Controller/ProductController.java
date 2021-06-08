package com.desafio.SocialMeli.Controller;

import com.desafio.SocialMeli.DTO.FollowedPostListDTO;
import com.desafio.SocialMeli.DTO.PostWithUserDTO;
import com.desafio.SocialMeli.DTO.ProductDTO;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductNotExistsException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO) throws ProductExistsException {
        return new ResponseEntity<>(iProductService.createProduct(productDTO), HttpStatus.OK);
    }

    @PostMapping("/newpost")
    public ResponseEntity<PostWithUserDTO> newPost (@RequestBody PostWithUserDTO postDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException {
        return new ResponseEntity<>(iProductService.newPost(postDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDTO> getFollowedPosts(@PathVariable int userId) {
        return new ResponseEntity<>(iProductService.getFollowedPosts(userId), HttpStatus.OK);
    }
}
