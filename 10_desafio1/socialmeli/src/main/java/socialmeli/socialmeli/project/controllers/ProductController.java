package socialmeli.socialmeli.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.IProductService;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    public ResponseEntity<?> addPost (@RequestBody PostDto postDto) throws PostAlreadyExistsException {
        iProductService.addNewPost(postDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("The post for "+postDto.getIdPost()+" has succesfully created");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
