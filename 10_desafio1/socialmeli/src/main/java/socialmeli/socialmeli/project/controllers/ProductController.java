package socialmeli.socialmeli.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoNotFoundException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;
import socialmeli.socialmeli.project.services.IProductService;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @PostMapping("/newpost")
    public ResponseEntity<?> addPost (@RequestBody PostDto postDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException {
        iProductService.addNewPost(postDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("The postId: "+postDto.getIdPost()+" has been succesfully created by userId: "+postDto.getUserId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostArrayDto> getPostList(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws NoPostsFoundException {
       return new ResponseEntity<>(iProductService.getArrayPostById(userId,order), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<?> newPromoPost(@RequestBody PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException, IdNotFoundException {
        iProductService.addNewPromoPost(postDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("The promo post id: "+postDto.getIdPost()+" has been succesfully created by "+postDto.getUserId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<PostPromoDto> getCountPromo(@PathVariable Integer userId) throws IdNotFoundException {
        return new ResponseEntity<>(iProductService.getCountPromo(userId),HttpStatus.OK);
    }

}
