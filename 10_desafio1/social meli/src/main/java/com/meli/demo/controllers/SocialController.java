package com.meli.demo.controllers;


import com.meli.demo.dtos.*;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.exceptions.PostDiscountException;
import com.meli.demo.exceptions.PostException;
import com.meli.demo.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("social")
public class SocialController {

    @Autowired
    SocialService FollowService;
    //POST http://localhost:8080/social/users/101/follow/1002
    //Punto 1 Seguir un vendedor
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> Follow(@PathVariable int userId, @PathVariable int userIdToFollow) throws FollowException {
        return new ResponseEntity<>(FollowService.Follow(userId,userIdToFollow), HttpStatus.OK);
    }
    //GET http://localhost:8080/social/users/1001/followers/count/
    //Punto 2 cantidad de usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<CountUsersDTO> countUser(@PathVariable int userId) throws FollowException {
        return new ResponseEntity<>(FollowService.countUsers(userId), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/users/1001/followers/list
    //Punto 3 listado de todos los usuarios que siguen a un determinado vendedor
    @GetMapping("/users/{UserID}/followers/list")
    public ResponseEntity<LisUsersResponseDTO> ListUsers(@PathVariable int UserID) throws FollowException {
        return new ResponseEntity<>(FollowService.listUsers(UserID), HttpStatus.OK);
    }
    //GET http://localhost:8080/social/users/101/followed/list
    //Punto 4 listado de todos los vendedores a los cuales sigue un determinado usuario
    @GetMapping("/users/{User}/followed/list")
    public ResponseEntity<ListSellersResponseDTO> ListaVendedores(@PathVariable int User) throws FollowException {

        return new ResponseEntity<>(FollowService.listVendedores(User), HttpStatus.OK);
    }


    /* POST
  {
    "userId":1001,
    "id_post":18,
    "date":"10-06-2021",
    "detail":
    {
        "product_id":1,
        "productName":"TESTG gamner",
        "type":"gamer",
        "brand":"Racer",
        "color":"red $ black",
        "notes":"special edition"
    },
    "category":100,
    "price":1500.50
}
     */

    //POST http://localhost:8080/social/products/newpost
    //Punto 5 Dar de alta una nueva publicación.
    @PostMapping("/products/newpost")
    public ResponseEntity<String> newPost(@RequestBody PostResponseDTO pubtDTO) throws PostException {
        return new ResponseEntity<>(FollowService.newPost(pubtDTO), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/products/followed/101/list
    //Punto 6 Obtener un listado de las publicaciones realizadas por los vendedores que un usuario
    //sigue en las últimas dos semanas
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<ListSellersPostDTO> listPostVendedors(@PathVariable int userId){
        return new ResponseEntity<>(FollowService.listPostVendedors(userId), HttpStatus.OK);
    }

    //POST http://localhost:8080/social/users/101/unfollow/1001
    //Punto 7 Dejar de seguir un vendedor
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public  ResponseEntity<String>   unFollow(@PathVariable int userId, @PathVariable int userIdToUnfollow) throws FollowException {
        return new ResponseEntity(FollowService.unFollow(userId,userIdToUnfollow),HttpStatus.OK);
    }


/*
    {
        "userId":1002,
            "id_post":18,
            "date":"29-04-2021",
            "detail":
        {
            "product_id":1,
                "productName":"TES2 gam",
                "type":"gamer",
                "brand":"Racer",
                "color":"red $ black",
                "notes":"special edition"
        },
        "category":100,
            "price":1500.50,
        "hasPromo":true,
        "discount":0.25
    }*/
    //POST http://localhost:8080/social/products/newpromopost
    //Punto 10 Llevar a cabo la publicación de un nuevo producto en promoción.
    @PostMapping("/products/newpromopost")
    public ResponseEntity<String> newPost(@RequestBody PostDTO postResponseDTO) throws  PostDiscountException {
        return new ResponseEntity<>(FollowService.newPostDiscount(postResponseDTO), HttpStatus.OK);
    }

    //GET http://localhost:8080/social/products/1002/countPromo/
    //Punto 11 Obtener la cantidad de productos en promoción de un determinado vendedor
    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<CountDiscountSelleDTO> countDiscount(@PathVariable int userId ){
        return new ResponseEntity<>(FollowService.countDiscount(userId),HttpStatus.OK);
    }

    //GET http://localhost:8080/social//products/1002/list/
    // Punto 12 listado de todos los productos en promoción de un determinado
    //vendedor
    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<ListDiscountDTO> listDiscount(@PathVariable int userId){
        return new ResponseEntity<>(FollowService.listDiscount(userId),HttpStatus.OK);
    }
}
