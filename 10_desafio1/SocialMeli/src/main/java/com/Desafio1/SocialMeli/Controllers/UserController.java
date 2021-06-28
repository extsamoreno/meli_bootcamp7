package com.Desafio1.SocialMeli.Controllers;

import com.Desafio1.SocialMeli.DTOS.CreateUserDTO;
import com.Desafio1.SocialMeli.DTOS.FollowedListDTO;
import com.Desafio1.SocialMeli.DTOS.FollowerCountDTO;
import com.Desafio1.SocialMeli.DTOS.FollowerListDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.NotSellerException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.User;
import com.Desafio1.SocialMeli.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService iUserService;


    @PostMapping("/new")
    public ResponseEntity<List<User>> createUser(@RequestBody CreateUserDTO createUserDTO) throws DuplicateIdException {
        return new ResponseEntity<>(iUserService.newUser(createUserDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsuarios(){
        return new ResponseEntity<>(iUserService.getUsers(), HttpStatus.OK);
    }

    //US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow) throws UserNotFoundException, DuplicateIdException, NotSellerException {
        iUserService.followSeller(userId, userIdToFollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un
    //determinado vendedor

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowerCountDTO>getFollowersCount(@PathVariable int userId) throws UserNotFoundException{
        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    //US 0003: Obtener un listado de todos los usuarios que siguen a un determinado
    //vendedor (¿Quién me sigue?)

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> getFollowersByUserId(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowersByUserId(userId, order), HttpStatus.OK);
    }

    //US 0004: Obtener un listado de todos los vendedores a los cuales sigue un
    //determinado usuario (¿A quién sigo?)

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedByUserId(@PathVariable int userId, @RequestParam(defaultValue = "name_asc") String order) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowedByUserId(userId, order), HttpStatus.OK);
    }
}
