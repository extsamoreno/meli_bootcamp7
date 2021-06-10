package com.reto1.demo.Controller;

import com.reto1.demo.Exception.*;
import com.reto1.demo.Model.DTO.PostObjects.LastPostDTO;
import com.reto1.demo.Model.DTO.PostObjects.PromoPostCount;
import com.reto1.demo.Model.DTO.UserObjets.UserPromoPostListDTO;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.PromoPost;
import com.reto1.demo.Service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {

    @Autowired
    IPostService iPostService;

    /**
     * Create a post
     */
    @PostMapping("/products/newpost")
    public ResponseEntity<String> createPost(@RequestBody Post post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException {
        String postname = iPostService.creatPost(post);
        return new ResponseEntity<>("The post " + postname + " was created", HttpStatus.OK);
    }

    /**
    Obtener un listado de las publicaciones realizadas por los vendedores que
    un usuario sigue en las últimas dos semanas
    Ordena en forma desc las fechas
    Devuelve tanto productos en promoción como productos normales
    */
    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<LastPostDTO> lastPosts(@PathVariable int userId,
                                                 @RequestParam(required = false, defaultValue = "date_desc") String order)
            throws UserIdNotFoundException, UserNotFollowException, OrderNotFoundException {
        return new ResponseEntity<>(iPostService.orderLastPost(userId, order), HttpStatus.OK);
    }

    /**
    * Create products
    */
    @PostMapping("/products/newpromopost")
    public ResponseEntity<String> createPromoPost(@RequestBody PromoPost post) throws UserIdNotFoundException, DuplicatedPostException, DateNotExistException, UserNotFollowException {
        String postname = iPostService.creatPost(post);
        return new ResponseEntity<>("The post " + postname + " was created", HttpStatus.OK);
    }

    /**
    * Obtener la cantidad de productos en promoción de un determinado
    * vendedor
    * */
    @GetMapping("/products/{userId}/countPromo/")
    public ResponseEntity<PromoPostCount> countPromoPost(@PathVariable int userId) throws UserNotFollowException, UserIdNotFoundException {
        return new ResponseEntity<>(iPostService.countPromoPost(userId),HttpStatus.OK);
    }

    /**
    * Obtener un listado de todos los productos en promoción de un
    * determinado vendedor
    * */
    @GetMapping("/products/{userId}/list/")
    public ResponseEntity<UserPromoPostListDTO> listPromoPost(@PathVariable int userId) throws UserNotFollowException, UserIdNotFoundException {
        return new ResponseEntity<>(iPostService.listPromoPost(userId),HttpStatus.OK);
    }
}





