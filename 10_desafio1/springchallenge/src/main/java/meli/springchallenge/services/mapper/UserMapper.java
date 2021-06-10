package meli.springchallenge.services.mapper;

import meli.springchallenge.dtos.UserDTO;
import meli.springchallenge.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<UserDTO> toDTO(List<User> users){

        return  users.stream().map(u-> new UserDTO(u.getUserId(), u.getUserName())).collect(Collectors.toList());

    }
}
