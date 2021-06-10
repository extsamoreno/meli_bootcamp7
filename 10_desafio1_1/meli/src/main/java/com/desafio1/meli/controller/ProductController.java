package com.desafio1.meli.controller;

import com.desafio1.meli.exceptions.FailCreatePublicationException;
import com.desafio1.meli.exceptions.NotExistUser;
import com.desafio1.meli.service.DTO.RequestFollowedProductList;
import com.desafio1.meli.service.DTO.RequestNewProduct;
import com.desafio1.meli.service.DTO.ResponseFollowersListDTO;
import com.desafio1.meli.service.orderType.PublicationOrderType;
import com.desafio1.meli.service.productService.IProductservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    IProductservice iProductservice;

    /**
     *
     * @param requestNewProduct
     * @return new Publications
     */
    @PostMapping("/newpost/")
    public ResponseEntity<Boolean> setPost(@RequestBody RequestNewProduct requestNewProduct) throws FailCreatePublicationException {
        return new ResponseEntity<Boolean>(iProductservice.newProduct(requestNewProduct), HttpStatus.BAD_REQUEST);

    }

    /**
     *
     * @param userId
     * @param order
     * @return followed list order to userId
     */
    @GetMapping("/followed/{userId}/list/")
    public ResponseEntity<RequestFollowedProductList> getFollower(@PathVariable Integer userId, @RequestParam(required = false) PublicationOrderType order) throws NotExistUser {

        RequestFollowedProductList status = iProductservice.listProductFollowerUser(userId, order);
        return new ResponseEntity<RequestFollowedProductList>(status, HttpStatus.OK);
    }
}
