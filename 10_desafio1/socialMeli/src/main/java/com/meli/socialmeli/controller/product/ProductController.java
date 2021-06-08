package com.meli.socialmeli.controller.product;

import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.service.product.IProductService;
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
    IProductService productService;

    @PostMapping("/newpost")
    public ResponseEntity<Void> createNewPost(@RequestBody PublicationDTO body) throws CanNotCreatePostException, InvalidDateFormatException {
        productService.createPost(body);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
