package bootcamp.desafio.spring.controller;

import bootcamp.desafio.spring.exception.DateException;
import bootcamp.desafio.spring.exception.PostUserNotFoundException;
import bootcamp.desafio.spring.model.Detail;
import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.service.IProductService;
import bootcamp.desafio.spring.service.dto.PostDTO;
import bootcamp.desafio.spring.service.dto.PostRequestDTO;
import bootcamp.desafio.spring.service.dto.ProductFollowedDTO;
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
    public ResponseEntity<HttpStatus> addNewpost(@RequestBody PostRequestDTO post) throws PostUserNotFoundException, DateException {
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


    @GetMapping()
    public ResponseEntity<ArrayList<Post>> getAll(){
        return new ResponseEntity<>(iProductService.getAll(),HttpStatus.OK);
    }

}
