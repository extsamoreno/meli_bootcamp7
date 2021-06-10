package desafio1.desafio1.service.userService;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.*;
import desafio1.desafio1.repository.IUserRepository;
import desafio1.desafio1.service.userService.dto.SellerCountDTO;
import desafio1.desafio1.service.userService.dto.SellerListDTO;
import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import desafio1.desafio1.service.userService.dto.UserListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService implements IUsersService {

   @Autowired
    IUserRepository userRepository;

    @Override//estoy devolviendo una instancia nueva, debeiria devolver la de la bdd
    public User follow(int userId, int userIdToFollow) throws UserNotFoundException, FollowException, FollowLoopException { //userIdToFollow es a quien quiero seguir
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        UserSaveDTO userSaveDTOFollow = new UserSaveDTO();

        if(userId == userIdToFollow){
            throw new FollowLoopException();
        }

        //hago eso porque en el find se fija si existe y no tengo que validar de nuevo aca
        userSaveDTO.setUserId(userRepository.findUserById(userId).getUserId());
        userSaveDTO.setUserName(userRepository.findUserById(userId).getUserName());


        userSaveDTOFollow.setUserId(userRepository.findUserById(userIdToFollow).getUserId());
        userSaveDTOFollow.setUserName(userRepository.findUserById(userIdToFollow).getUserName());

        //validar si ya lo sigo, si es asi, no deberia volver a agregarlo a la lista
        List<UserSaveDTO> userSaveDTOList = userRepository.findUserById(userId).getFollowList();
        Optional<UserSaveDTO> item = userSaveDTOList.stream().filter(
                i -> i.getUserId() == userIdToFollow).findFirst();

        if(item.isPresent()){
            throw new FollowException(userIdToFollow);
        }

        userRepository.findUserById(userId).getFollowList().add(userSaveDTOFollow);
        userRepository.findUserById(userIdToFollow).getFollowMeList().add(userSaveDTO);

        return userRepository.findUserById(userId);
    }

    @Override
    public SellerCountDTO countFollowersUserById(int userId) throws UserNotFoundException, ValidateSellerException {
        SellerCountDTO sellerCountDTO = new SellerCountDTO();
        User user = new User();
        user = userRepository.findUserById(userId);

        sellerCountDTO.setUserId(user.getUserId());
        sellerCountDTO.setUserName(user.getUserName());

        //valido que en la lista haya usuarios que siguen a este vendedor, y obtengo el tamaño
        sellerCountDTO.setFollowers_count(userRepository.filterFollowersMe(userId, "usuario").size());

        if(!sellerCountDTO.getUserName().contains("vendedor")){  //REVISAR ESTO, LO HICE RAPIDO, NO ESTOY SEGURA
            throw new ValidateSellerException(sellerCountDTO.getUserId());
        }

        return sellerCountDTO;
    }

    @Override
    public SellerListDTO listFollowersSeller(int userId) throws UserNotFoundException, ValidateSellerException {
        SellerListDTO sellerListDTO = new SellerListDTO();

        User user = new User();
        user = userRepository.findUserById(userId);

        sellerListDTO.setUserId(user.getUserId());
        sellerListDTO.setUserName(user.getUserName());

        //valido que en la lista haya usuarios que siguen a este vendedor, y obtengo el tamaño
        sellerListDTO.setFollowMeList(userRepository.filterFollowersMe(userId, "usuario"));

        if(!sellerListDTO.getUserName().contains("vendedor")){  //Valido si yo soy un vendedor
            throw new ValidateSellerException(sellerListDTO.getUserId());
        }

        return sellerListDTO;

    }

    @Override
    public UserListDTO listFollowedUser(int userId) throws UserNotFoundException, ValidateUserException {
        UserListDTO userListDTO = new UserListDTO();
        User user = new User();
        user = userRepository.findUserById(userId);

        userListDTO.setUserId(user.getUserId());
        userListDTO.setUserName(user.getUserName());

        userListDTO.setFollowList(userRepository.filterFollowers(userId, "vendedor"));

        if(!userListDTO.getUserName().contains("usuario")){
            throw new ValidateUserException(userListDTO.getUserId());
        }

        return userListDTO;

    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException {
        userRepository.unfollow(userId,userIdToUnfollow);
    }
}
