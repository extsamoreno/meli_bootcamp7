package com.example.socialmeli.repository;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IUserRepository {
    User userAdd(User user);

    boolean userFollow(int userid, int useridFollow);

    User getUserById(int userId);

    boolean userUnFollow(int userid, int useridFollow);
}
