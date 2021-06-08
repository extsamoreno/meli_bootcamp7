package desafio1.desafio1.service;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.UserNotFoundException;
import desafio1.desafio1.exception.ValidateSellerException;
import desafio1.desafio1.repository.IUserRepository;
import desafio1.desafio1.service.dto.SellerDTO;
import desafio1.desafio1.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService {

   @Autowired
    IUserRepository userRepository;

    @Override
    public UserDTO follow(int userId, int userIdToFollow) throws UserNotFoundException { //userIdToFollow es a quien quiero seguir
        UserDTO userDTO = new UserDTO();

        userRepository.findUserById(userId).getFollowList().add(userRepository.findUserById(userIdToFollow));
        userRepository.findUserById(userIdToFollow).getFollowMeList().add(userRepository.findUserById(userId));

        userDTO.setUserId(userRepository.findUserById(userIdToFollow).getUserId());
        userDTO.setUserName(userRepository.findUserById(userIdToFollow).getUserName());

        return userDTO;
    }

    @Override
    public SellerDTO countFollowersById(int userId) throws UserNotFoundException, ValidateSellerException {
        SellerDTO sellerDTO = new SellerDTO();
        User user = new User();
        user = userRepository.findUserById(userId);

        sellerDTO.setUserId(user.getUserId());
        sellerDTO.setUserName(user.getUserName());
        sellerDTO.setFollowers_count(user.getFollowMeList().size());

        if(!sellerDTO.getUserName().contains("vendedor")){  //REVISAR ESTO, LO HICE RAPIDO, NO ESTOY SEGURA
            throw new ValidateSellerException(sellerDTO.getUserId());
        }

        return sellerDTO;
    }
}
