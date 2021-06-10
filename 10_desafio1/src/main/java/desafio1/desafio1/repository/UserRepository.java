package desafio1.desafio1.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import desafio1.desafio1.domain.Publications;
import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.productException.UnfollowException;
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

    //chiterio va a ser "vendedor" o "usuario" entonces todos los userSaveTDO que contengan en el nombre, uno de esos, se va a guardar en la lista que voy a devolver
    //filtra los que sigo
    @Override
    public List<UserSaveDTO> filterFollowers(int userId, String criterio) throws UserNotFoundException {
        //User user = findUserById(userId);
        List<UserSaveDTO> listFollowers = new ArrayList<>();
        List<UserSaveDTO> listUserSaveDTO = findUserById(userId).getFollowList();

        boolean contains = false;
        if(listUserSaveDTO != null){
            for(UserSaveDTO u : listUserSaveDTO){
                contains = u.getUserName().toLowerCase().contains(criterio.toLowerCase());
                if(contains == true) {
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
    public List<UserSaveDTO> filterFollowersMe(int userId, String criterio) throws UserNotFoundException {
        User user = findUserById(userId);
        List<UserSaveDTO> listFollowersMe = new ArrayList<>(); //ACA HABIA UN NULL, LO CAMBIE PORQUE EN EL METODO DE ARRIBA TIRABA ERROR, SI NO ANDA LO PONGO EN NULL DE NUEVO
        List<UserSaveDTO> listUserSaveDTO = user.getFollowMeList();

        if(listUserSaveDTO != null){
            listFollowersMe = listUserSaveDTO.stream().filter(
                    x -> x.getUserName().toLowerCase().contains(criterio.toLowerCase())).collect(Collectors.toList());
        }

        return listFollowersMe;

    }

   @Override
    public List<Publications> findPublicationByUserID(int userId) throws UserNotFoundException {
        return findUserById(userId).getPublicationsList();
    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) throws UserNotFoundException, UnfollowException, ValidateSellerException {
        User user = findUserById(userId);
        User userToUnfollow = findUserById(userIdToUnfollow);

        removeFollowMe(user, userToUnfollow);
        removeFollow(user, userToUnfollow);

    }

    private void removeFollowMe(User user, User userToUnfollow) throws UnfollowException { //eliminar quien me sigue
        List<UserSaveDTO> listFollowMe = new ArrayList<>();
        listFollowMe = user.getFollowMeList();
        boolean flag = false;

        if(listFollowMe != null){
            for(int i=0 ; i<listFollowMe.size() ; i++){
                if(listFollowMe.get(i).getUserId() == userToUnfollow.getUserId()){
                    for(int j=0 ; j<listUser.size() ; j++){
                        if(listUser.get(j).getUserId() == user.getUserId()){
                            flag = true;
                            listUser.get(j).getFollowMeList().remove(userToUnfollow);
                        }
                    }

                }
            }

        }
    }

    private void removeFollow(User user, User userToUnfollow) throws UnfollowException, ValidateSellerException { //eliminar quien sigo
        List<UserSaveDTO> listFollow = new ArrayList<>();
        listFollow = user.getFollowList();
        boolean flag = false; //se que esta feo

        //validar que es un vendedor a quien dejo de seguir

        if (!userToUnfollow.getUserName().contains("vendedor")) {  //Valido si quien voy a dejar de seguir es un vendedor
            throw new ValidateSellerException(user.getUserId());
        }

        if(listFollow != null){
            for(int i=0 ; i<listFollow.size() ; i++){
                if(listFollow.get(i).getUserId() == userToUnfollow.getUserId()){
                    for(int j=0 ; j<listUser.size() ; j++){
                        if(listUser.get(j).getUserId() == user.getUserId()){
                            flag = true;
                            listUser.get(j).getFollowMeList().remove(userToUnfollow);
                        }
                    }
                }
            }
            if(flag == false) throw new UnfollowException(userToUnfollow.getUserId());
        }
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
