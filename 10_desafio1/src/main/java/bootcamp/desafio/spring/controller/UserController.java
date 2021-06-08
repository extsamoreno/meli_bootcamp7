package bootcamp.desafio.spring.controller;

import bootcamp.desafio.spring.exception.UserNotFoundException;
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
    public ResponseEntity<?> followSeller(@PathVariable(name = "userId",required = true) Long userId,
                                          @PathVariable(name = "userIdToFollow",required = true) Long sellerId) throws UserNotFoundException {
        iUserService.follow(userId,sellerId);
        return new ResponseEntity<>(null, HttpStatus.OK);
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
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("{userId}/followers/list")
    public ResponseEntity<ArrayList<UserDTO>> followSellerList(@PathVariable(name = "userId",required = true) Long userId) throws UserNotFoundException {
        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.OK);
    }



}
