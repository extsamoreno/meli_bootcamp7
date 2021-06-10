package desafio1.desafio1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import desafio1.desafio1.domain.Publications;
import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.FollowException;
import desafio1.desafio1.exception.userException.UnfollowException;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    //I moved this around because I was recommended to do it as a class attribute and not as a method
    private List<User> listUser = null;

    public UserRepository() {
        this.listUser = loadDataBase();
    }

    @Override
    public User findUserById(int userId) throws UserNotFoundException {

        User userResult = null;

        if(listUser != null){
            Optional<User> item = listUser.stream().filter(u -> u.getUserId() == userId).findFirst();

            if(item.isPresent()) {
                userResult = item.get();
            }
        }

        if(userResult==null){
            throw new UserNotFoundException(userId);
        }

        return userResult;
    }

    //criteria will be 1 if it is a seller or 0 if it is a user then all the userSaveTDO that are of a type will be saved in the list that I am going to return
    // filter the ones I follow
    @Override
    public List<UserSaveDTO> filterFollowers(int userId, int criterio) throws UserNotFoundException {

        List<UserSaveDTO> listFollowers = new ArrayList<>();
        List<UserSaveDTO> listUserSaveDTO = findUserById(userId).getFollowList();

        boolean contains = false;
        if(listUserSaveDTO != null){
            for(UserSaveDTO u : listUserSaveDTO){
                contains = u.getIsSeller()==1;
                if(contains) {
                    listFollowers.add(u);
                }
            }
        }
        return listFollowers;
    }


    //filter those who follow me
    @Override
    public List<UserSaveDTO> filterFollowersMe(int userId, int criterio) throws UserNotFoundException {
        User user = findUserById(userId);
        List<UserSaveDTO> listFollowersMe = new ArrayList<>();
        List<UserSaveDTO> listUserSaveDTO = user.getFollowMeList();

        if(listUserSaveDTO != null){
            listFollowersMe = listUserSaveDTO.stream().filter(
                    x -> x.getIsSeller() == criterio).collect(Collectors.toList());
        }
        return listFollowersMe;
    }

   @Override
    public List<Publications> findPublicationByUserID(int userId) throws UserNotFoundException {
        return findUserById(userId).getPublicationsList();
    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException {

        removeFollowMe(userId, userIdToUnfollow);
        removeFollow(userId, userIdToUnfollow);

    }

    //they stop following me
    private void removeFollowMe(int userId, int userIdToUnfollow) throws UnfollowException { //eliminar quien me sigue

        User use = listUser.stream().filter(x -> x.getUserId()==userIdToUnfollow).findFirst().orElseThrow(
                () -> new UnfollowException(userIdToUnfollow)
        );
        UserSaveDTO userToRemove = use.getFollowMeList().stream().filter(
                x -> x.getUserId()==userId).findFirst().orElseThrow(
                () -> new UnfollowException(userId));

        use.getFollowMeList().remove(userToRemove);


    }

    //I stop following them
    private void removeFollow(int userId, int userIdToUnfollow) throws UnfollowException, ValidateSellerException, UserNotFoundException { //eliminar quien sigo
        //validate that it is a seller whom I unfollow
        if(findUserById(userIdToUnfollow).getIsSeller()==0) {
            throw new ValidateSellerException(findUserById(userIdToUnfollow).getUserId());
        }

        User use = listUser.stream().filter(x -> x.getUserId()==userId).findFirst().orElseThrow(
                () -> new UnfollowException(userId)
        );
        UserSaveDTO userToRemove = use.getFollowList().stream().filter(
                x -> x.getUserId()==userIdToUnfollow).findFirst().orElseThrow(
                () -> new UnfollowException(userIdToUnfollow));

        use.getFollowList().remove(userToRemove);

    }


    private List<User> loadDataBase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:user.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        List<User> listUsers = null;

        try{
            listUsers = objectMapper.readValue(file , typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return listUsers;
    }
}
