package com.socialmeli.desafio.controller;


import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
import com.socialmeli.desafio.dto.PublicacionesVendedoresSeguidosDTO;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ISocialService iSocialService;

    @PostMapping("/newpost")  //CU0005
    public ResponseEntity<HttpStatus> newPost(@RequestBody PublicacionModel publicacion) throws VendedorIdNotFoundException, UserIdNotFoundException {
        iSocialService.createPost(publicacion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")  //CU0006
    public ResponseEntity<PublicacionesVendedoresSeguidosDTO> postByVendedores (@PathVariable int userId, @RequestParam (required = false, defaultValue = "") String order) throws UserIdNotFoundException {
        return new ResponseEntity<>(iSocialService.publicacionesVendedoresSeguidosDosSemanas(userId,order),HttpStatus.OK);
    }



}
