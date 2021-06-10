package bootcamp.desafio.spring.controller;

import bootcamp.desafio.spring.exception.DateException;
import bootcamp.desafio.spring.exception.PostException;
import bootcamp.desafio.spring.exception.PostUserNotFoundException;
import bootcamp.desafio.spring.model.Detail;
import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.service.IProductService;
import bootcamp.desafio.spring.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    /**
     * Dar de alta una nueva publicación
     * @param post
     * @return httpResponse
     * @throws PostUserNotFoundException
     */
    @PostMapping("/newpost")
    public ResponseEntity<HttpStatus> addNewPost(@RequestBody PostRequestDTO post) throws PostUserNotFoundException, DateException {
        iProductService.addNewPost(post);
        return new ResponseEntity<>(HttpStatus.OK,HttpStatus.OK);
    }

    /**
     * Obtener un listado de las publicaciones realizadas por los vendedores que
     * un usuario sigue en las últimas dos semanas (para esto tener en cuenta
     * ordenamiento por fecha, publicaciones más recientes primero).
     * @param userId
     * @return
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductFollowedDTO> getPostTheFollows(@PathVariable(name = "userId",required = true) Long userId,
                                                                @RequestParam(value = "order", required = false,defaultValue = "") String order){
        return new ResponseEntity<>(iProductService.getPostTheFollows(userId,order),HttpStatus.OK);
    }

    /**
     * method to get all post, it is used to update .json file
     * @return
     */
    @GetMapping()
    public ResponseEntity<ArrayList<Post>> getAll(){
        return new ResponseEntity<>(iProductService.getAll(),HttpStatus.OK);
    }


    /**
     * Llevar a cabo la publicación de un nuevo producto en promoción
     * @param post
     * @return
     * @throws PostUserNotFoundException
     * @throws DateException
     */
    @PostMapping("/newpromopost")
    public ResponseEntity<HttpStatus> addNewPromoPost(@RequestBody PostRequestDTO post) throws PostException, DateException {
        iProductService.addNewPostPromo(post);
        return new ResponseEntity<>(HttpStatus.OK,HttpStatus.OK);
    }

    /**
     * Obtener la cantidad de productos en promoción de un determinado
     * vendedor
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<CantPromoDTO> getPromosBySeller(@PathVariable("userId") Long userId) throws PostUserNotFoundException {
        return new ResponseEntity<>(iProductService.getPromosBySeller(userId),HttpStatus.OK);
    }


    /**
     * Obtener la cantidad de productos en promoción de un determinado
     * vendedor
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/list")
    public ResponseEntity<PostPromoListDTO> getPromosBySellerList(@PathVariable("userId") Long userId) throws PostUserNotFoundException {
        return new ResponseEntity<>(iProductService.getPromosBySellerList(userId),HttpStatus.OK);
    }
}
