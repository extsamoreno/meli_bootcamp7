package com.meli.socialmeli.model.mapper;

import com.meli.socialmeli.model.dao.model.User;
import com.meli.socialmeli.model.dto.*;
import com.meli.socialmeli.util.SortDescNameUserUtil;
import com.meli.socialmeli.util.SortAscNameUserUtil;

import java.util.ArrayList;
import java.util.Collections;

public class UsersMapper {
    public static UserSellerCountDTO changeToUserSellerCountDTO(User user) {
        return new UserSellerCountDTO(user.getUserId(), user.getUserName(), user.getCantFollowed());
    }

    public static UserSellerListDTO changeToUserSellerListDTO(User user, String order) {
        UserSellerListDTO newUserSellerDTO = new UserSellerListDTO();
        newUserSellerDTO.setUserId(user.getUserId());
        newUserSellerDTO.setUserName(user.getUserName());
        ArrayList<User> userList = user.getUsersFollowed();
        if (order.equals("name_asc")) {
            Collections.sort(userList, new SortAscNameUserUtil());
        }
        if (order.equals("name_desc")) {
            Collections.sort(userList, new SortDescNameUserUtil());
        }
        for (User userOfList: userList) {
            newUserSellerDTO.getFollowers().add(UsersMapper.changeTouserSimpleDTO(userOfList));
        }
        return newUserSellerDTO;
    }

    public static UserListDTO changeToUserListDTO(User user, String order) {
        UserListDTO newUserListDTO = new UserListDTO();
        newUserListDTO.setUserId(user.getUserId());
        newUserListDTO.setUserName(user.getUserName());
        ArrayList<User> userList = user.getUsersFollowed();
        if (order.equals("name_asc")) {
            Collections.sort(userList, new SortAscNameUserUtil());
        }
        if (order.equals("name_desc")) {
            Collections.sort(userList, new SortDescNameUserUtil());
        }
        for (User userOfList: userList) {
            newUserListDTO.getFollowed().add(UsersMapper.changeTouserSimpleDTO(userOfList));
        }
        return newUserListDTO;
    }

    private static UserSimpleDTO changeTouserSimpleDTO (User user) {
        return new UserSimpleDTO(user.getUserId(), user.getUserName());
    }

    public static UserListPostDTO changeToUserListPostDTO(User user) {
        UserListPostDTO userListPostDTO = new UserListPostDTO();
        userListPostDTO.setUserId(user.getUserId());
        return userListPostDTO;
    }
}
