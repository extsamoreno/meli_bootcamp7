package com.example.socialmeli.repository;

import com.example.socialmeli.DTO.Response.UserFolCouResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolLisResponseDTO;
import com.example.socialmeli.DTO.Response.UserFolsLisResponseDTO;
import com.example.socialmeli.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IUserRepository {

    ResponseStatus userAdd (UserDTO user);
    ResponseStatus userAddList (List<UserDTO> user);
    //Requirement 1
    //Follow
    boolean userFollow (int userid, int useridFollow);
    //Requirement 2
    //Followers count
    UserFolCouResponseDTO getFollowersCount(int userId);
    //Requirement 3
    //Followers list
    UserFolsLisResponseDTO getFollowersList(int userId);
    //Requirement 4
    //Followed list
    UserFolLisResponseDTO getFollowedList(int userId);
    //Requirement 7
    //UnFollow
    boolean userUnFollow (int userid, int useridFollow);
}
