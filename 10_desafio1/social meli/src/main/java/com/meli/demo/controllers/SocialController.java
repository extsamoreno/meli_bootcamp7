package com.meli.demo.controllers;


import com.meli.demo.dtos.*;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.services.mappers.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("social")
public class SocialController {

    @Autowired
    SocialService FollowService;

    @GetMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<String> calcularEdad(@PathVariable int userId, @PathVariable int userIdToFollow) throws FollowException {
        return new ResponseEntity<>(FollowService.Follow(userId,userIdToFollow), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/count/")
    public ResponseEntity<CantidadUsuariosDTO> cantidadUsuarios(@PathVariable int userId) throws FollowException {
        return new ResponseEntity<>(FollowService.countUsers(userId), HttpStatus.OK);
    }


    @GetMapping("/users/{UserID}/followers/list")
    public ResponseEntity<ListadoUsuariosResponseDTO> ListaUsuarios(@PathVariable int UserID) throws FollowException {

        return new ResponseEntity<>(FollowService.listUsers(UserID), HttpStatus.OK);
    }

    @GetMapping("/users/{User}/followed/list")
    public ResponseEntity<ListaVendedoresResponseDTO> ListaVendedores(@PathVariable int User) throws FollowException {

        return new ResponseEntity<>(FollowService.listVendedores(User), HttpStatus.OK);
    }
/*
    @PostMapping("/products/newpost")
    public ResponseEntity<ListaVendedoresResponseDTO> nuevaPublicaciòn(@RequestBody PublicacionDTO pubtDTO) throws FollowException {

        return new ResponseEntity<>(FollowService.listVendedores(User), HttpStatus.OK);
    }
    */




}
