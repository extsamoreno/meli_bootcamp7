package com.desafio.SocialMeli.Controller;

import com.desafio.SocialMeli.DTO.Post.ListPromoPostDTO;
import com.desafio.SocialMeli.DTO.Post.PostWithUserDTO;
import com.desafio.SocialMeli.DTO.Post.PromoCountDTO;
import com.desafio.SocialMeli.DTO.Post.PromoPostWithUserDTO;
import com.desafio.SocialMeli.DTO.Product.ProductDTO;
import com.desafio.SocialMeli.DTO.User.FollowedPostListDTO;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductNotExistsException;
import com.desafio.SocialMeli.Exception.User.OrderNotFoundException;
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
    // Create a product
    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct (@RequestBody ProductDTO productDTO) throws ProductExistsException {
        return new ResponseEntity<>(iProductService.createProduct(productDTO), HttpStatus.OK);
    }
    //US0005 - Create a new post (without discount)
    @PostMapping("/newpost")
    public ResponseEntity<PostWithUserDTO> newPost (@RequestBody PostWithUserDTO postDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException {
        return new ResponseEntity<>(iProductService.newPost(postDTO), HttpStatus.OK);
    }
    //US0006 - Get last 14 days posts by user followed
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDTO> getFollowedPosts(@PathVariable int userId, @RequestParam(required = false) String order) throws OrderNotFoundException {
        return new ResponseEntity<>(iProductService.getFollowedPosts14Days(userId, order), HttpStatus.OK);
    }
    //US0010 - Create a new promo post
    @PostMapping("/newpromopost")
    public ResponseEntity<PostWithUserDTO> newPromoPost (@RequestBody PromoPostWithUserDTO promoPostWithUserDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException {
        return new ResponseEntity<>(iProductService.newPromoPost(promoPostWithUserDTO), HttpStatus.OK);
    }
    //US0011 - Get promo post count by userId
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PromoCountDTO> getPromoPostCount (@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iProductService.getPromoPostCount(userId), HttpStatus.OK);
    }
    //US0012 - Get promo posts by userId
    @GetMapping("/{userId}/list/")
    public ResponseEntity<ListPromoPostDTO> getPromoPostListByUserId (@PathVariable int userId) throws UserIdNotFoundException {
        return new ResponseEntity<>(iProductService.getPromoPostListByUserId(userId), HttpStatus.OK);
    }
}
