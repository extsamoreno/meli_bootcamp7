package socialmeli.socialmeli.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostArrayDto> getPostList
            (@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws NoPostsFoundException {
       return new ResponseEntity<>(iProductService.getArrayPostById(userId,order), HttpStatus.OK);
    }


}
