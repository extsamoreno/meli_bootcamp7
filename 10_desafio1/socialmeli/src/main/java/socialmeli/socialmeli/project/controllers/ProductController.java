package socialmeli.socialmeli.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.*;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoListDto;
import socialmeli.socialmeli.project.services.IProductService;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    //Create a new post
    @PostMapping("/newpost")
    public ResponseEntity<?> addPost (@RequestBody PostDto postDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException, InvalidPostDateException {
        iProductService.addNewPost(postDto);
        ArrayList<String> response = new ArrayList<>();
        response.add("The postId: "+postDto.getIdPost()+" has been succesfully created by userId: "+postDto.getUserId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Get post list from a userId
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostArrayDto> getPostList(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "date_asc") String order) throws NoPostsFoundException, IdNotFoundException {
       return new ResponseEntity<>(iProductService.getArrayPostById(userId,order), HttpStatus.OK);
    }

    //Create a new promo post
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

    @GetMapping("/{userId}/list")
    public ResponseEntity<PostPromoListDto> getPostPromoList (@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "productname_asc") String order){
        return new ResponseEntity<>(iProductService.getPostPromoList(userId, order),HttpStatus.OK);
    }

}
