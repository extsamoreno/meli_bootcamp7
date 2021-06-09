package com.meli.socialmeli.util;

import com.meli.socialmeli.dto.UserDTO;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserUtil {

    public static List<UserDTO> sortFollows(List<UserDTO> follows, String order) {

        if ("name_desc".equals(order)) {
            return orderFollowersByNameDesc(follows);
        }
        return orderFollowersByNameAsc(follows);
    }

    private static List<UserDTO> orderFollowersByNameAsc(List<UserDTO> followers) {

        return followers.stream().sorted(
                Comparator.comparing(UserDTO::getUserName)).collect(Collectors.toList());
    }

    private static List<UserDTO> orderFollowersByNameDesc(List<UserDTO> followers) {

        return followers.stream().sorted(
                Comparator.comparing(UserDTO::getUserName).reversed()).collect(Collectors.toList());
    }
}
