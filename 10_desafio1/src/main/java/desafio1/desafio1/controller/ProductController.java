package desafio1.desafio1.controller;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.service.productService.IProductService;
import desafio1.desafio1.service.productService.dto.PostsDTO;
import desafio1.desafio1.service.productService.dto.PublicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @PostMapping("/newpost") //devuelvo la publicaion solo para corroborar despues le tengo que cambiar a void
    public ResponseEntity<User> newPost(@RequestBody PublicationDTO publicationDTO) throws UserNotFoundException, ValidateSellerException {
        return new ResponseEntity<>(productService.newPost(publicationDTO), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list") //ver las publicaciones de 2 semanas para aca de sellers que sigo
    public ResponseEntity<PostsDTO> listPublication(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<>(productService.listPublication(userId, order), HttpStatus.OK);
    }


}
