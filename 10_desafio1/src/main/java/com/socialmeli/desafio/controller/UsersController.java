package com.socialmeli.desafio.controller;

import com.socialmeli.desafio.Exception.SeguidorNoRegistradoException;
import com.socialmeli.desafio.Exception.SeguidorYaRegistradoException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
import com.socialmeli.desafio.dto.FollowedListDTO;
import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.dto.FollowersListDTO;
import com.socialmeli.desafio.model.VendedorModel;
import com.socialmeli.desafio.service.ISocialService;
import com.socialmeli.desafio.socialRepository.IInitRepository;
import com.socialmeli.desafio.socialRepository.IUserRepository;
import com.socialmeli.desafio.socialRepository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IInitRepository iInitRepository;

    @Autowired
    IVendedorRepository iVendedorRepository;

    @Autowired
    ISocialService iSocialService;



    @PostMapping("/crearDB")
    public void crearDB() throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorYaRegistradoException {    //Se crea la base de datos de prueba
        iInitRepository.altaUsuarios();
        iInitRepository.altaVendedores();
        iInitRepository.follow();
        //iInitRepository.createPost();



    }

    @PostMapping("/listar")    //Se listan las BD, prueba para verificar que funciona ok
    public void listar()  {
       iUserRepository.listarUsuarios();
       iVendedorRepository.listarVendedores();


    }

    @PostMapping("/listarPublicacionesPorVendedor/{id}")    //Se listan las BD, prueba para verificar que funciona ok
    public void listarPublicaciones(@PathVariable int id)  {
       VendedorModel vendedor= iVendedorRepository.getVendedorById(id);

    }


    @PostMapping("/{id}/follow/{userIdToFollow}")   //CU0001
    public ResponseEntity<Void> follow (@PathVariable int id, @PathVariable int userIdToFollow) throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorYaRegistradoException {
       iSocialService.follow(id, userIdToFollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/unFollow/{userIdToUnfollow}")   //CU0007
    public ResponseEntity<Void> unFollow (@PathVariable int id, @PathVariable int userIdToUnfollow) throws UserIdNotFoundException, VendedorIdNotFoundException, SeguidorNoRegistradoException {

        iSocialService.unfollow(id, userIdToUnfollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}/followers/count/")  //CU0002
    public ResponseEntity<FollowersCountDTO> followersCount (@PathVariable int id)throws VendedorIdNotFoundException{

        return new ResponseEntity<>(iSocialService.getCountFollowers(id),HttpStatus.OK);
    }


   @GetMapping("/{id}/followers/list")  //CU0003 y CU0008
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable int id, @RequestParam (required = false, defaultValue = "") String order)throws VendedorIdNotFoundException{
       System.out.println(order);
        return new ResponseEntity<>(iSocialService.getFollowersList(id,order),HttpStatus.OK);
    }



    @GetMapping("/{id}/followed/list")  //CU0004 y CU0008
    public ResponseEntity<FollowedListDTO> followedList (@PathVariable int id, @RequestParam (required = false, defaultValue = "")String order)throws UserIdNotFoundException{

        return new ResponseEntity<>(iSocialService.getFollowedList(id,order),HttpStatus.OK);
    }








}
