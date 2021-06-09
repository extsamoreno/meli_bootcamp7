package desafio1.demo.Controller;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.PromoPostWithoutPromoException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.*;
import desafio1.demo.Service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    @RequestMapping("/newpost")
    public ResponseEntity addNewPost(@RequestBody NewPostRequestDTO newPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException {
        iProductService.addNewPost(newPostRequestDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("/newpromopost")
    public ResponseEntity addNewPromoPost(@RequestBody NewPromoPostRequestDTO newPromoPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException, PromoPostWithoutPromoException {
        iProductService.addNewPromoPost(newPromoPostRequestDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/followed/{userId}/list")
    public ResponseEntity<PostListFromFollowedDTO> getPostListFromFollowed (@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<PostListFromFollowedDTO>(iProductService.getPostListFromFollowed(userId, order),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{userId}/countPromo")
    public ResponseEntity<PromoCountDTO> getPromoCountDTOById(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iProductService.getPromoCountDTOById(userId),HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/{userId}/list")
    public ResponseEntity<PromoListDTO> getPromoListDTOById(@PathVariable int userId) throws UserNotFoundException {
        return new ResponseEntity<>(iProductService.getPromoListDTOById(userId),HttpStatus.OK);
    }
}
