package com.socialmeli.desafio.controller;


import com.socialmeli.desafio.dto.FollowedListDTO;
import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.dto.FollowersListDTO;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.model.VendedorModel;
import com.socialmeli.desafio.service.ISocialService;
import com.socialmeli.desafio.socialRepository.IInitRepository;
import com.socialmeli.desafio.socialRepository.IUsuarioRepository;
import com.socialmeli.desafio.socialRepository.IVendedorRepository;
import com.socialmeli.desafio.socialRepository.InitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {


     @Autowired
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    IInitRepository iInitRepository;

    @Autowired
    IVendedorRepository iVendedorRepository;

    @Autowired
    ISocialService iSocialService;



    @PostMapping("/crearDB")
    public void crearDB()  {    //Se crea la base de datos
        iInitRepository.altaUsuarios();
        iInitRepository.altaVendedores();

    }

    @PostMapping("/listar")    //Se listan las BD, prueba para verificar que funciona ok
    public void listar()  {
       iUsuarioRepository.listarUsuarios();
       iVendedorRepository.listarVendedores();


    }

    @PostMapping("/listarPublicacionesPorVendedor/{id}")    //Se listan las BD, prueba para verificar que funciona ok
    public void listarPublicaciones(@PathVariable int id)  {
       VendedorModel vendedor= iVendedorRepository.getVendedorById(id);
        System.out.println(vendedor.getPosts().get(0).getDetail());


    }


    @PostMapping("/{id}/follow/{userIdToFollow}")   //CU0001
    public ResponseEntity<HttpStatus> follow (@PathVariable int id, @PathVariable int userIdToFollow)  {

        iSocialService.follow(id, userIdToFollow);

        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);   //falta hacer las excepciones
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}/followers/count/")  //CU0002
    public ResponseEntity<FollowersCountDTO> followersCount (@PathVariable int id){  //falta hacer las excepciones

        return new ResponseEntity<>(iSocialService.getCountFollowers(id),HttpStatus.OK);
    }


    @GetMapping("/{id}/followers/list")  //CU0003
    public ResponseEntity<FollowersListDTO> followersList (@PathVariable int id){  //falta hacer las excepciones

        return new ResponseEntity<>(iSocialService.getFollowersList(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/followed/list")  //CU0004
    public ResponseEntity<FollowedListDTO> followedList (@PathVariable int id){  //falta hacer las excepciones

        return new ResponseEntity<>(iSocialService.getFollowedList(id),HttpStatus.OK);
    }







}
