package com.example.socialmeli.service;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IUserService {
    UserDTO userAdd (UserDTO user);
    List<UserDTO> userAddList (List<UserDTO> user);
    boolean userFollow (int userid, int useridFollow);
    UserFolCouResponseDTO getFollowersCount(int userId);
    UserFolsLisResponseDTO getFollowersList(int userId, String order);
    UserFolLisResponseDTO getFollowedList(int userId,String order);
    boolean userUnFollow (int userid, int useridFollow);
}
