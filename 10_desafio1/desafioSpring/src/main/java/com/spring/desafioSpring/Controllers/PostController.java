package com.spring.desafioSpring.Controllers;

import com.spring.desafioSpring.DTOs.PostDTO;
import com.spring.desafioSpring.Exceptions.PostIdExistsException;
import com.spring.desafioSpring.Services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class PostController {

    @Autowired
    IPostService iPostService;

    //US0005
    @PostMapping("/newpost")
    public ResponseEntity newPost(@RequestBody PostDTO postDTO) throws PostIdExistsException {
        iPostService.insertPost(postDTO);
        return new ResponseEntity(HttpStatus.OK);
    }



}


