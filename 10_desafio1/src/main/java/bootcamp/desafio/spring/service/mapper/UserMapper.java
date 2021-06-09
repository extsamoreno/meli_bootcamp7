package bootcamp.desafio.spring.service.mapper;

import bootcamp.desafio.spring.model.User;
import bootcamp.desafio.spring.service.dto.UserDTO;

import java.util.ArrayList;

public class UserMapper {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getUserId(),user.getUserName());
    }

    public static User toUser(UserDTO user){
        return new User(user.getUserId(), user.getUserName(), new ArrayList<>());
    }

}
