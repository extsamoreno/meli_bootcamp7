package desafio1.demo.Controller;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.NewPostDTO;
import desafio1.demo.Model.DTO.PostListFromFollowedDTO;
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
    public ResponseEntity addNewPost(@RequestBody NewPostDTO newPostDTO) throws DuplicatePostIdException, UserNotFoundException {
        iProductService.addNewPost(newPostDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/followed/{userId}/list")
    public ResponseEntity<PostListFromFollowedDTO> getPostListFromFollowed (@PathVariable int userId, @RequestParam(required = false) String order) throws UserNotFoundException {
        return new ResponseEntity<PostListFromFollowedDTO>(iProductService.getPostListFromFollowed(userId, order),HttpStatus.OK);
    }
}
