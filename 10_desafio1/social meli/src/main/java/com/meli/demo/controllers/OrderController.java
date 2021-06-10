package com.meli.demo.controllers;


import com.meli.demo.dtos.ListDiscountDTO;
import com.meli.demo.dtos.ListSellersPostDTO;
import com.meli.demo.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    SocialService FollowService;

    //http://localhost:8080/order/users/105/followers/list?order=name_asc
    //http://localhost:8080/order/users/105/followers/list?order=name_desc

    @GetMapping("/users/{UserID}/followers/list")
    public ResponseEntity<ListSellersPostDTO> orderNameDesc(@PathVariable int UserID, @RequestParam(required = false) String order) {
        System.out.println("Hola mund2");
        return new ResponseEntity<>(FollowService.orderNameAscDesc(UserID,order), HttpStatus.OK);
    }


    //http://localhost:8080/order/products/followed/105/list?order=date_asc
    //http://localhost:8080/order/products/followed/105/list?order=date_desc

    @GetMapping("/products/followed/{userId}/list")
    public  ResponseEntity<ListSellersPostDTO>   orderDateDesc(@PathVariable int userId,@RequestParam(required = false) String order) {

        System.out.println("Hola mund");
        return new ResponseEntity<>(FollowService.orderDateAscDesc(userId,order), HttpStatus.OK);
    }


    //http://localhost:8080/order/products/1002/list?order=name_desc
    //http://localhost:8080/order/products/1002/list?order=name_asc
    @GetMapping("/products/{userId}/list")
    public  ResponseEntity<ListDiscountDTO>   orderDtoNameDesc(@PathVariable int userId,@RequestParam(required = false) String order) {
        return new ResponseEntity<>(FollowService.orderDtoNameDesc(userId,order), HttpStatus.OK);
    }

}
