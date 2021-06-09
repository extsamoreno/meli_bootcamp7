package com.example.challenge.Controllers;

import com.example.challenge.Exceptions.InvalidOrderException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Services.DTOs.PostDTO;
import com.example.challenge.Services.DTOs.PostPromotionDTO;
import com.example.challenge.Services.DTOs.ResponseFollowedPostDTO;
import com.example.challenge.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;


    @PostMapping("/newpost")
    public ResponseEntity<String> addNewPost(@RequestBody PostDTO postDTO) throws UserNotFoundException {

        return new ResponseEntity<>(iProductService.addNewPost(postDTO), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<String> addNewPromoPost(@RequestBody PostPromotionDTO postPromoDTO) throws UserNotFoundException, InvalidOrderException {

        return new ResponseEntity<>(iProductService.addNewPromoPost(postPromoDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ResponseFollowedPostDTO> getMyFollowedPostList(@PathVariable int userId,@RequestParam(required = false,
            defaultValue = "") String order)
            throws UserNotFoundException, InvalidOrderException {
        return new ResponseEntity(iProductService.getMyFollowedPostList(userId, order), HttpStatus.OK);
    }




}
