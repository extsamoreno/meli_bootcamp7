package com.socialmeli.desafio.controller;


import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
import com.socialmeli.desafio.dto.CountPromoDTO;
import com.socialmeli.desafio.dto.FollowersCountDTO;
import com.socialmeli.desafio.dto.PromoListVendedorDTO;
import com.socialmeli.desafio.dto.PublicacionesVendedoresSeguidosDTO;
import com.socialmeli.desafio.model.PublicacionModel;
import com.socialmeli.desafio.service.ISocialService;
import com.socialmeli.desafio.service.mapper.SocialMapper;
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

    @PostMapping("/newpromopost")  //CU0010
    public ResponseEntity<HttpStatus> newPromoPost(@RequestBody PublicacionModel publicacion) throws VendedorIdNotFoundException, UserIdNotFoundException {
        iSocialService.createPost(publicacion);
        System.out.println(publicacion.getDiscount());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{userId}/countPromo/")  //CU0011
    public ResponseEntity<CountPromoDTO> countPromo (@PathVariable int userId)throws VendedorIdNotFoundException{
        return new ResponseEntity<>(iSocialService.countPromoBySeller(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/list")  //CU0012
    public ResponseEntity<PromoListVendedorDTO> promoListSeller (@PathVariable int userId,  @RequestParam (required = false, defaultValue = "") String order)throws VendedorIdNotFoundException{
        return new ResponseEntity<>(iSocialService.listPromo(userId,order),HttpStatus.OK);
    }



}
