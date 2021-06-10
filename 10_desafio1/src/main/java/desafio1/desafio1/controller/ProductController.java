package desafio1.desafio1.controller;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.publicationException.PublicatiosException;
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

    /**
     * Allows to register a new post.
     * @param publicationDTO
     * @return
     * @throws UserNotFoundException
     * @throws ValidateSellerException
     */
    @PostMapping("/newpost")
    public ResponseEntity<Void> newPost(@RequestBody PublicationDTO publicationDTO) throws UserNotFoundException, ValidateSellerException, PublicatiosException {
        productService.newPost(publicationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *allows you to get posts up to two weeks old from sellers that a particular user(userId) follows.
     * @param userId
     * @param order
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsDTO> listPublication(@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<>(productService.listPublication(userId, order), HttpStatus.OK);
    }

}
