package bootcamp.desafio.spring.controller;

import bootcamp.desafio.spring.exception.UserNotFoundException;
import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.service.IUserService;
import bootcamp.desafio.spring.service.dto.UserCountFollowersDTO;
import bootcamp.desafio.spring.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    /**
     * Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * @param userId
     * @param sellerId
     * @return
     */
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> followSeller(@PathVariable(name = "userId",required = true) Long userId,
                                          @PathVariable(name = "userIdToFollow",required = true) Long sellerId) throws UserNotFoundException {
        iUserService.follow(userId,sellerId);
        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }


    /**
     * Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
     * @param userId
     * @param sellerId
     * @return
     */
    @PostMapping("/{userId}/unfollow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> unfollowSeller(@PathVariable(name = "userId",required = true) Long userId,
                                                   @PathVariable(name = "userIdToFollow",required = true) Long sellerId) throws UserNotFoundException {
        iUserService.unfollow(userId,sellerId);
        return new ResponseEntity<>(HttpStatus.OK, HttpStatus.OK);
    }


    /**
     * Obtener el resultado de la cantidad de usuarios que siguen a un
     * determinado vendedor
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserCountFollowersDTO> followSeller(@PathVariable(name = "userId",required = true) Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.countFollowers(userId), HttpStatus.OK);
    }


    /**
     * Obtener un listado de todos los usuarios que siguen a un determinado
     * vendedor (¿Quién me sigue?)
     * @param userId
     * @return lista de la gente que sige a un vendedor
     * @throws UserNotFoundException
     */
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<ArrayList<UserDTO>> followerSellerList(@PathVariable(name = "userId",required = true) Long userId,
                                                                 @RequestParam(value = "order", required = false,defaultValue = "") String order) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowers(userId,order), HttpStatus.OK);
    }


    /**
     * Obtener un listado de todos los vendedores a los cuales sigue un
     * determinado usuario (¿A quién sigo?)
     * @param userId
     * @return listo de la gente a quien sige una persona
     * @throws UserNotFoundException
     */
    @GetMapping("{userId}/followed/list")
    public ResponseEntity<ArrayList<UserDTO>> followsList(@PathVariable(name = "userId",required = true) Long userId,
                                                          @RequestParam(value = "order", required = false,defaultValue = "") String order) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollows(userId,order), HttpStatus.OK);
    }

    /**
     * method to get all post, it is used to update .json file
     * @return
     */
    @GetMapping()
    public ResponseEntity<ArrayList<User>> getAll(){

        return new ResponseEntity<>(iUserService.findAll(), HttpStatus.OK);
    }

}
