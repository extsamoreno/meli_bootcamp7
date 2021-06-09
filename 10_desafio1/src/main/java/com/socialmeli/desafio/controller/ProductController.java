package com.socialmeli.desafio.controller;


import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.service.ISocialService;
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
    ISocialService iSocialService;

    @PostMapping("/newpost")  //CU0005
    public ResponseEntity<HttpStatus> newPost(@RequestBody PublicacionModel publicacion)  {
        System.out.println("publicacion" + publicacion);
        iSocialService.createPost(publicacion);
        return new ResponseEntity<>(HttpStatus.OK);   //faltaria hacerlo mas prolijo con un DTO y Mapper
    }





}
