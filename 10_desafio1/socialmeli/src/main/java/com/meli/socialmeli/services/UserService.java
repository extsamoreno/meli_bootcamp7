package com.meli.socialmeli.services;

import com.meli.socialmeli.Mappers.UserMapper;
import com.meli.socialmeli.dto.UserFollowDTO;
import com.meli.socialmeli.dto.UserFollowedByListDTO;
import com.meli.socialmeli.dto.UserFollowerCount;
import com.meli.socialmeli.dto.UserFollowerListDTO;
import com.meli.socialmeli.exceptions.*;
import com.meli.socialmeli.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    /**
     * Recibe como parametros los dos Id de los usuarios, verifica que no sean el mismo y los envia al Repository
     * para ser guardados en la base de datos, en el repository tambien se verifica si el usuario al que se pretende
     * seguir es un vendedor o si ya está en la lista de seguidos del primer usuario.
     * @param userId id del usuario que lanza la petición.
     * @param userIdToFollow Id del vendedor a seguir.
     * @return UserFollowDTO contiene el Id del usuario seguidor y el nombre del usuario seguido. Y un estatus Http .OK
     * @throws UserInvalidException Verifica si el vendedor no esté en la lista de seguidos del usuario.
     * @throws UserItselfException Verifica que el usuario a seguir no sea el mismo que lanza la petición.
     * @throws UserIsNotMerchant Verifica que el usuario a seguir sea un vendedor.
     * @throws UserDoNotExistsException Verifica que el usuario esté en la base de datos.
     */
    @Override
    public UserFollowDTO follow(int userId, int userIdToFollow) throws UserInvalidException, UserItselfException, UserIsNotMerchant, UserDoNotExistsException {
        if (userId != userIdToFollow) {
            return UserMapper.UserMeliToFollowDTO(iUserRepository.followMerchant(userId, userIdToFollow));
        } else {
            throw new UserItselfException();
        }
    }

    /**
     * Recibe como parametro el Id del usuario a consultar el número de seguidores
     * @param userId Id del vendedor a consultar
     * @return UserFollowerCount contiene el Id del usuario consultado, su nombre y el número de seguidores
     */
    @Override
    public UserFollowerCount getFollowerCount(int userId) {
        return UserMapper.UserMeliToUserFollowerCount(iUserRepository.getFollowerCountById(userId));
    }

    /**
     * Recibe como paramatros el Id del usuario a consultar, y un string que indica
     * el tipo de ordenamiento ( name_asc o name_desc). Retorna el Id del usuario consultado, el nombre y la lista
     * de los usuarios a quien sigue.
     * @param userId Id del usuario a consultar.
     * @param order String opcional para elegir la forma de ordenamiento, ascendente o descendente.
     * @return UserFollowerListDTO contiene el Id de usuario consultado, el nombre de usuario y la lista de los usuarios
     * que sigue.
     */
    @Override
    public UserFollowerListDTO getFollowerList(int userId, String order) {
        return iUserRepository.getListFollowersById(userId, order);
    }

    /**
     * Recibe como paramatros el Id del usuario a consultar, y un string que indica
     * el tipo de ordenamiento ( name_asc o name_desc). Retorna el Id del usuario consultado, el nombre y la lista
     * de los usuarios que lo siguen.
     * @param userId Id del usuario a consultar.
     * @param order String opcional para elegir la forma de ordenamiento, ascendente o descendente.
     * @return UserFollowedByListDTO contiene el Id de usuario consultado, el nombre de usuario y la lista de los usuarios
     * que lo siguen.
     */
    @Override
    public UserFollowedByListDTO getFollowedBy(int userId, String order) {
        return iUserRepository.getListFollowedById(userId, order);
    }

    /**
     * Recibe como parametros los dos Id de los usuarios, verifica que no sean el mismo y los envia al Repository
     * para ser borrado en la base de datos.
     * @param userId Id del usuario que realiza la petición.
     * @param userIdTounfollow Id del susuario para dejar de seguir.
     * @return UserFollowDTO contiene el id del usuario consultado, y el nombre del usuario que se dejó de seguir.
     * Ademas una respuesta HTTP .OK
     * @throws UserNotFoundException Verifica si el vendedor no esté en la lista de seguidos del usuario.
     */
    @Override
    public UserFollowDTO unfollow(int userId, int userIdTounfollow) throws UserNotFoundException {
        if (userId != userIdTounfollow) {
            return UserMapper.UserMeliToFollowDTO(iUserRepository.unfollowMerchant(userId, userIdTounfollow));
        } else {
            throw new UserNotFoundException();
        }
    }
}
