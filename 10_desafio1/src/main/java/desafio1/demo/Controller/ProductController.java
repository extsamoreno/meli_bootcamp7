package desafio1.demo.Controller;

import desafio1.demo.Exception.DuplicatePostIDException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.NewPostDTO;
import desafio1.demo.Service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    @RequestMapping("/newpost")
    public ResponseEntity addNewPost(@RequestBody NewPostDTO newPostDTO) throws DuplicatePostIDException, UserNotFoundException {
        iProductService.addNewPost(newPostDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
