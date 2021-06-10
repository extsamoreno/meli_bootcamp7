package bootcamp.desafio.spring.service;

import bootcamp.desafio.spring.exception.UserNotFoundException;
import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.service.dto.UserCountFollowersDTO;
import bootcamp.desafio.spring.service.dto.UserDTO;

import java.util.ArrayList;

public interface IUserService {


    void follow(Long userId, Long sellerId) throws UserNotFoundException;

    /**
     * metodo para saber la cantidad de seguidores
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    UserCountFollowersDTO countFollowers(Long userId) throws UserNotFoundException;

    /**
     * metodo para obtener la lista de usuarios que siguen la persona (Vendedor) a la cual corresponde el userId,
     * y ordenar la lista alfabeticamente
     * @param userId
     * @param order
     * @return  ArrayList<UserDTO>
     */
    ArrayList<UserDTO> getFollowers(Long userId, String order);

    /**
     * metodo para obtener la lista de usuarios a los que sigo la persona a la cual corresponde el userId,
     * y ordenar la lista alfabeticamente
     * @param userId
     * @param order
     * @return ArrayList<UserDTO>
     */
    ArrayList<UserDTO> getFollows(Long userId, String order);

    /**
     * metodo para dejar de seguir a un vendedor
     * @param userId
     * @param sellerId
     */
    void unfollow(Long userId, Long sellerId);

    /**
     * metodo para consultar toda la tabla de usuarios
     * utilizado para actualizar archivo .json
     * @return ArrayList<User>
     */
    ArrayList<User> findAll();
}
