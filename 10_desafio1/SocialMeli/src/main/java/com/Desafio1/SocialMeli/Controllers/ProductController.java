package com.Desafio1.SocialMeli.Controllers;

import com.Desafio1.SocialMeli.DTOS.FollowedPostListDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Services.IProductService;
import com.Desafio1.SocialMeli.Services.IUserService;
import com.Desafio1.SocialMeli.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService iProductService;

    //US 0005: Dar de alta una nueva publicación

    @PostMapping("/newpost")
    public ResponseEntity<?> createNewPost(@RequestBody Post post) throws DuplicateIdException, UserNotFoundException {
        iProductService.createNewPost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que
    //un usuario sigue en las últimas dos semanas (para esto tener en cuenta
    //ordenamiento por fecha, publicaciones más recientes primero).

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostListDTO> getFollowedPostListByUserId(@PathVariable int userId, @RequestParam(defaultValue = "date_asc") String order) throws UserNotFoundException, ParseException {
        return new ResponseEntity<>(iProductService.getFollowedPostListByUserId(userId, order), HttpStatus.OK);
    }

}
