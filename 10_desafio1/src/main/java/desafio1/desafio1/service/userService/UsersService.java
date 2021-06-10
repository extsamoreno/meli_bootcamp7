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

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService {

   @Autowired
    IUserRepository userRepository;

    @Override
    public User follow(int userId, int userIdToFollow) throws UserNotFoundException, FollowException, FollowLoopException { //userIdToFollow es a quien quiero seguir
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        UserSaveDTO userSaveDTOFollow = new UserSaveDTO();

        if(userId == userIdToFollow){
            throw new FollowLoopException();
        }

        //in findUserById is exception handling
        userSaveDTO.setUserId(userRepository.findUserById(userId).getUserId());
        userSaveDTO.setUserName(userRepository.findUserById(userId).getUserName());
        userSaveDTO.setIsSeller(userRepository.findUserById(userId).getIsSeller());


        userSaveDTOFollow.setUserId(userRepository.findUserById(userIdToFollow).getUserId());
        userSaveDTOFollow.setUserName(userRepository.findUserById(userIdToFollow).getUserName());
        userSaveDTOFollow.setIsSeller(userRepository.findUserById(userIdToFollow).getIsSeller());

        //validate if I already follow it, if so, I shouldn't add it back to the list
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
        sellerCountDTO.setIsSeller(user.getIsSeller());

        //I validate that in the list there are users who follow this seller, and I get the size
        sellerCountDTO.setFollowers_count(userRepository.filterFollowersMe(userId, 0).size());

        if(sellerCountDTO.getIsSeller() ==0){
            throw new ValidateSellerException(sellerCountDTO.getUserId());
        }

        return sellerCountDTO;
    }

    @Override
    public SellerListDTO listFollowersSeller(int userId, String order) throws UserNotFoundException, ValidateSellerException {
        SellerListDTO sellerListDTO = new SellerListDTO();

        User user = new User();
        user = userRepository.findUserById(userId);

        sellerListDTO.setUserId(user.getUserId());
        sellerListDTO.setUserName(user.getUserName());
        sellerListDTO.setIsSeller(user.getIsSeller());

        //I find a list of users who follow this seller.
        sellerListDTO.setFollowMeList(userRepository.filterFollowersMe(userId, 0));

        if(sellerListDTO.getIsSeller()==0){  //Valido si yo soy un vendedor
            throw new ValidateSellerException(sellerListDTO.getUserId());
        }

        if(order == null) return sellerListDTO;

        sortByName(sellerListDTO.getFollowMeList(), order);

        return sellerListDTO;

    }



    @Override
    public UserListDTO listFollowedUser(int userId, String order) throws UserNotFoundException, ValidateUserException {
        UserListDTO userListDTO = new UserListDTO();
        User user = new User();
        user = userRepository.findUserById(userId);

        userListDTO.setUserId(user.getUserId());
        userListDTO.setUserName(user.getUserName());
        userListDTO.setIsSeller(user.getIsSeller());

        userListDTO.setFollowList(userRepository.filterFollowers(userId, 1)); ///1 es vendedor

        if(userListDTO.getIsSeller()==1){ //validamos que no sea un vendedor
            throw new ValidateUserException(userListDTO.getUserId());
        }

        if(order == null) return userListDTO;

        sortByName(userListDTO.getFollowList(), order);

        return userListDTO;

    }

    private void sortByName(List<UserSaveDTO> list , String order){
        if(order.equals("name_asc")) list.sort(Comparator.comparing(UserSaveDTO::getUserName));
        else if(order.equals("name_desc")) list.sort(Comparator.comparing(UserSaveDTO::getUserName).reversed());

    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException {
        userRepository.unfollow(userId,userIdToUnfollow);
    }
}
