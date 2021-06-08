package com.socialMeli.product;

import com.socialMeli.product.exceptions.FailCreatePostException;
import com.socialMeli.product.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PublicationController {

    @Autowired
    iPublicationService service;

    @PostMapping("/newPost")
    public ResponseEntity<Void> newPost (@RequestBody Post newPost) throws FailCreatePostException {
        return (new ResponseEntity<>(service.newPost(newPost), HttpStatus.OK));
    }

}
