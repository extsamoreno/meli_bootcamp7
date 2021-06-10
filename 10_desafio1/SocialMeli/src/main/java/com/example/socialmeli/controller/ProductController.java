package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.DTO.Response.*;
import com.example.socialmeli.exceptions.UserIdNotFountException;
import com.example.socialmeli.service.IProductService;
import com.example.socialmeli.service.IPublicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    IProductService iProductService;
    IPublicationService iPublicationService;

    public ProductController(IProductService iProductService, IPublicationService iPublicationService) {
        this.iProductService = iProductService;
        this.iPublicationService = iPublicationService;
    }

    //US 0005 add new "post" publication
    @PostMapping("/newpost")
    public ResponseEntity<PublicationCreateResponseDTO> addPublication(@RequestBody PublicationDTO publication) {
        return new ResponseEntity<>(iPublicationService.addPublication(publication), HttpStatus.OK);
    }

    // US 0006 get all "post" publication by userId
    // US 0009  order all by date asc-desc
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationFollowedUserResponseDTO> getProductsFollowedUser(@PathVariable int userId, @RequestParam(required = false) String order) throws UserIdNotFountException {
        return new ResponseEntity<>(iPublicationService.getPublicationFollowedUser(userId, order), HttpStatus.OK);
    }

    // US 0010 add new "post" publication promo
    @PostMapping("/newpromopost")
    public ResponseEntity<PublicationPromoCreateResponseDTO> addPromoPublication(@RequestBody PublicationPromoDTO publication) {
        return new ResponseEntity<>(iPublicationService.addPublication(publication), HttpStatus.OK);
    }

    // US 0011 get all "posts" publications from user by userid
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PublicationPromoCountResponseDTO> getProductsPromoCount(@PathVariable int userId) {
        return new ResponseEntity<>(iPublicationService.getPublicationsPromoCount(userId), HttpStatus.OK);
    }

    // US 0012 get all "posts" publications from user by userid
    @GetMapping("/{userId}/list")
    public ResponseEntity<List<PublicationPromoDTO>> getProductsPromoList(@PathVariable int userId) {
        return new ResponseEntity<>(iPublicationService.getPublicationsPromo(userId), HttpStatus.OK);
    }


    //Additional end point

    //Add product to list in memory
    @PostMapping("/add")
    public ResponseEntity<ProductCreateResponseDTO> addProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(iProductService.addProducts(product), HttpStatus.OK);
    }

    //add list product to lost in memory
    @PostMapping("/add/list")
    public ResponseEntity<List<ProductCreateResponseDTO>> addProductList(@RequestBody List<ProductDTO> products) {
        return new ResponseEntity<>(iProductService.addProducts(products), HttpStatus.OK);
    }

    //Get all products in list memory
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return new ResponseEntity<>(iProductService.getProducts(), HttpStatus.OK);
    }

    // add list of publication in list memory
    @PostMapping("/newpost/list")
    public ResponseEntity<List<PublicationCreateResponseDTO>> addPublicationList(@RequestBody List<PublicationDTO> publication) {
        return new ResponseEntity<>(iPublicationService.addPublication(publication), HttpStatus.OK);
    }
}
