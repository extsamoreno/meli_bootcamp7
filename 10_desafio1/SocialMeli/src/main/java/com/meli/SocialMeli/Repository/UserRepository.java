package com.meli.SocialMeli.Repository;

import com.meli.SocialMeli.DTO.CreateUserDTO;
import com.meli.SocialMeli.DTO.UserDTO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    // Atributos
    private List<UserDTO> userList;

    public UserRepository(){
        this.userList = new ArrayList<>();
    }

    @Override
    public List<UserDTO> createUser(CreateUserDTO createUserDTO) {
        this.userList = createUserDTO.getUserDTOList();
        return this.userList;
    }

    @Override
    public UserDTO searchUserById(int userId) {
        return userList.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean followSeller(int userId, int userIdToFollow) {
        UserDTO buyer = this.searchUserById(userId);
        UserDTO seller = this.searchUserById(userIdToFollow);

        if(buyer == null || seller == null){
            return false;
        }

        // Agrego el seller a la lista de seguidos del buyer
        List<UserDTO> followed = buyer.getFollowed();
        followed.add(seller);
        buyer.setFollowed(followed);
        this.userList.set(this.userList.indexOf(buyer), buyer);

        // Agrego el buyer a la lista de seguidores del seller
        List<UserDTO> followers = seller.getFollowers();
        followers.add(buyer);
        seller.setFollowers(followers);
        this.userList.set(this.userList.indexOf(seller), seller);

        return true;
    }

}
