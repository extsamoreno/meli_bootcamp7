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

    private List<User> listUser = null; //esto lo cambie de lugar porque me recomendaron hacerlo como atributo de clase y no de metodo

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

    //criterio va a ser 1 si es vendedor o 0 si es usuario entonces todos los userSaveTDO que sean de un tipo se va a guardar en la lista que voy a devolver
    //filtra los que sigo
    @Override
    public List<UserSaveDTO> filterFollowers(int userId, int criterio) throws UserNotFoundException {
        //User user = findUserById(userId);
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

            /* listFollowers = listUserSaveDTO.stream().filter(
                    x -> x.getUserName().toLowerCase().contains(criterio.toLowerCase())).collect(Collectors.toList());*/
        }


        return listFollowers;

    }
    //filtra los que me siguen a mi
    @Override
    public List<UserSaveDTO> filterFollowersMe(int userId, int criterio) throws UserNotFoundException {
        User user = findUserById(userId);
        List<UserSaveDTO> listFollowersMe = new ArrayList<>(); //ACA HABIA UN NULL, LO CAMBIE PORQUE EN EL METODO DE ARRIBA TIRABA ERROR, SI NO ANDA LO PONGO EN NULL DE NUEVO
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

    //me dejan de seguir
    private void removeFollowMe(int userId, int userIdToUnfollow) throws UnfollowException { //eliminar quien me sigue

        User use = listUser.stream().filter(x -> x.getUserId()==userIdToUnfollow).findFirst().orElseThrow(
                () -> new UnfollowException(userIdToUnfollow)
        );
        UserSaveDTO userToRemove = use.getFollowMeList().stream().filter(
                x -> x.getUserId()==userId).findFirst().orElseThrow(
                () -> new UnfollowException(userId));

        use.getFollowMeList().remove(userToRemove);


    }

    //dejar de seguir
    private void removeFollow(int userId, int userIdToUnfollow) throws UnfollowException, ValidateSellerException, UserNotFoundException { //eliminar quien sigo
        //validar que es un vendedor a quien dejo de seguir
        if(findUserById(userIdToUnfollow).getIsSeller()==0) {  //Valido si quien voy a dejar de seguir es un vendedor (si es 0 es un usuario comun)
            throw new ValidateSellerException(findUserById(userIdToUnfollow).getUserId()); //OJO CAMBIE ALGO
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
