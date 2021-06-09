package com.example.socialmeli.controller;

import com.example.socialmeli.DTO.ProductDTO;
import com.example.socialmeli.DTO.PublicationDTO;
import com.example.socialmeli.DTO.PublicationPromoDTO;
import com.example.socialmeli.DTO.Response.ProductCreateResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationCreateResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationFollowedUserResponseDTO;
import com.example.socialmeli.DTO.Response.PublicationPromoCreateResponseDTO;
import com.example.socialmeli.service.IProductService;
import com.example.socialmeli.service.IPublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @Autowired
    IPublicationService iPublicationService;

    @PostMapping("/add")
    public ResponseEntity<ProductCreateResponseDTO> addProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity<>(iProductService.addProducts(product), HttpStatus.OK);
    }

    @PostMapping("/add/list")
    public ResponseEntity<List<ProductCreateResponseDTO>> addProductList(@RequestBody List<ProductDTO> products) {
        return new ResponseEntity<>(iProductService.addProducts(products), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return new ResponseEntity<>(iProductService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<List<PublicationPromoDTO>> getProductsPromo(@PathVariable int userId) {
        return new ResponseEntity<>(iPublicationService.getPublicationsPromo(userId), HttpStatus.OK);
    }

    @PostMapping("/newpost")
    public ResponseEntity<PublicationCreateResponseDTO> addPublication(@RequestBody PublicationDTO publication) {
        return new ResponseEntity<>(iPublicationService.addPublication(publication), HttpStatus.OK);
    }
    @PostMapping("/newpromopost")
    public ResponseEntity<PublicationPromoCreateResponseDTO> addPromoPublication(@RequestBody PublicationPromoDTO publication) {
        return new ResponseEntity<>(iPublicationService.addPublication(publication), HttpStatus.OK);
    }

    @PostMapping("/newpost/list")
    public ResponseEntity<List<PublicationCreateResponseDTO>> addPublication(@RequestBody List<PublicationDTO> publication) {
        return new ResponseEntity<>(iPublicationService.addPublication(publication), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PublicationFollowedUserResponseDTO> getProductsFollowedUser(@PathVariable int userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(iPublicationService.getPublicationFollowedUser(userId,order), HttpStatus.OK);
    }
}
