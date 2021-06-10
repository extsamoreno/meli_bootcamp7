package com.socialmeli.desafio.controller;

import com.socialmeli.desafio.Exception.FollowerNotRegisteredException;
import com.socialmeli.desafio.Exception.RegisteredFollowerException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.SellerIdNotFoundException;
import com.socialmeli.desafio.dto.FollowedListDTO;
import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.dto.FollowersListDTO;
import com.socialmeli.desafio.model.SellerModel;
import com.socialmeli.desafio.service.ISocialService;
import com.socialmeli.desafio.socialRepository.IInitRepository;
import com.socialmeli.desafio.socialRepository.IUserRepository;
import com.socialmeli.desafio.socialRepository.ISellerRepository;
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
    ISellerRepository iSellerRepository;

    @Autowired
    ISocialService iSocialService;


 // ESTE ENDPOINT SE UTILIZA EN LAS PRUEBAS PARA CARGAR INICIALMENTE CLIENTES, VENDEDORES Y RELACIONES DE SEGUIMIENTO
 // SE DEBE CORRER ESTE ENDPOINT ANTES DE HACER PRUEBAS.  Ver archivo postman!
    @PostMapping("/crearDB")
    public void crearDB() throws UserIdNotFoundException, SellerIdNotFoundException, RegisteredFollowerException {
        iInitRepository.altaUsuarios();
        iInitRepository.altaVendedores();
        iInitRepository.follow();

        /*
        Se crean usuarios ID del 1 al 7
        Se crean vendedores ID del 1 al 7
        Usuario 1 sigue a vendedor 1
        Usuario 2 sigue a vendedores 1, 2 y 3
        Usuario 3 sigue a vendedores 1, 3 y 5
         */
    }

    //PARA TESTING
    @PostMapping("/listar")
    public void listar()  {
       iUserRepository.listUsers();
       iSellerRepository.listSeller();
    }

    //PARA TESTING
    @PostMapping("/listarPublicacionesPorVendedor/{id}")
    public void listarPublicaciones(@PathVariable int id)  {
       SellerModel vendedor= iSellerRepository.getVendedorById(id);

    }


    @PostMapping("/{id}/follow/{userIdToFollow}")   //CU0001
    public ResponseEntity<Void> follow (@PathVariable int id, @PathVariable int userIdToFollow) throws UserIdNotFoundException, SellerIdNotFoundException, RegisteredFollowerException {
       iSocialService.follow(id, userIdToFollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/unFollow/{userIdToUnfollow}")   //CU0007
    public ResponseEntity<Void> unFollow (@PathVariable int id, @PathVariable int userIdToUnfollow) throws UserIdNotFoundException, SellerIdNotFoundException, FollowerNotRegisteredException {

        iSocialService.unfollow(id, userIdToUnfollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}/followers/count/")  //CU0002
    public ResponseEntity<FollowersCountDTO> followersCount (@PathVariable int id)throws SellerIdNotFoundException {

        return new ResponseEntity<>(iSocialService.getCountFollowers(id),HttpStatus.OK);
    }


   @GetMapping("/{id}/followers/list")  //CU0003 y CU0008
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable int id, @RequestParam (required = false, defaultValue = "") String order)throws SellerIdNotFoundException {
       System.out.println(order);
        return new ResponseEntity<>(iSocialService.getFollowersList(id,order),HttpStatus.OK);
    }



    @GetMapping("/{id}/followed/list")  //CU0004 y CU0008
    public ResponseEntity<FollowedListDTO> followedList (@PathVariable int id, @RequestParam (required = false, defaultValue = "")String order)throws UserIdNotFoundException{
        return new ResponseEntity<>(iSocialService.getFollowedList(id,order),HttpStatus.OK);
    }




}
