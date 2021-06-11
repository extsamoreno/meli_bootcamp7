package com.example.demo.user;

public class UserMapper {

    public static UserDTO getUserDTO(User user){
        return new UserDTO(user.getName(), user.getSurname());
    }

    public static User getUser(UserDTO userDTO){
        return new User(userDTO.getName(), userDTO.getSurname());
    }
}
