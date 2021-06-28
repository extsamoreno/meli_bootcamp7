package com.Desafio1.SocialMeli.Repositories;

import com.Desafio1.SocialMeli.DTOS.CreateUserDTO;
import com.Desafio1.SocialMeli.DTOS.UserDTO;
import com.Desafio1.SocialMeli.Exceptions.DuplicateIdException;
import com.Desafio1.SocialMeli.Exceptions.UserNotFoundException;
import com.Desafio1.SocialMeli.Models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> userList;

    public UserRepository(){
        this.userList = new ArrayList<>();
    }

    @Override
    public List<User> createUser(CreateUserDTO createUserDTO) throws DuplicateIdException {
        for (User userDTO:createUserDTO.getUserList()) {

            // Verifico que no haya usuarios con el mismo id
            if(this.userList.stream().anyMatch(user -> user.getUserId() == userDTO.getUserId())){
                throw new DuplicateIdException("Ya existe un usuario con el id '" + userDTO.getUserId() + "'.");
            }

            // Agrego usuario a la lista de usuarios
            this.userList.add(userDTO);
        }
        return this.userList;
    }

    @Override
    public void updateUser(User seller) {
        this.userList.set(this.userList.indexOf(seller), seller);
    }

    @Override
    public List<User> readUsers() {
        return userList;
    }

    private void validateUser(int userId, User user) throws UserNotFoundException {
        // Valido que el usuario exista, sino tiro una excepcion
        if(user == null){
            throw new UserNotFoundException("El usuario con el id '" + userId + "' no existe.");
        }
    };

    @Override
    public User searchUserById(int userId) throws UserNotFoundException {
        // Busco y retorno el usuario en la lista de usuarios, si no existe -> null
        User user = userList.stream()
                .filter(us -> us.getUserId() == userId)
                .findFirst()
                .orElse(null);

        // Valido la existencia del usuario, sino tiro error
        this.validateUser(userId, user);

        return user;
    }

    @Override
    public void followSeller(User buyer, User seller) throws DuplicateIdException {
        UserDTO buyerDTO = new UserDTO();
        UserDTO sellerDTO = new UserDTO();

        // Verifico que el buyer no haya seguido anteriormente al seller
        if(buyer.getFollowed().stream().anyMatch(user -> user.getUserId() == seller.getUserId())){
            throw new DuplicateIdException("El comprador ya sigue al vendedor.");
        }

        // Verifico que el usuario no se este siguiendo a si mismo
        if(buyer.getUserId() == seller.getUserId()){
            throw new IllegalArgumentException("Un usuario no se puede seguir a si mismo.");
        }

        // Agrego el seller a la lista de seguidos del buyer
        buyerDTO.setUserId(seller.getUserId());
        buyerDTO.setUserName(seller.getUserName());

        List<UserDTO> followed = buyer.getFollowed();
        followed.add(buyerDTO);
        buyer.setFollowed(followed);
        this.userList.set(this.userList.indexOf(buyer), buyer);

        // Agrego el buyer a la lista de seguidores del seller
        sellerDTO.setUserId(buyer.getUserId());
        sellerDTO.setUserName(buyer.getUserName());

        List<UserDTO> followers = seller.getFollowers();
        followers.add(sellerDTO);
        seller.setFollowers(followers);
        this.userList.set(this.userList.indexOf(seller), seller);
    }
}
