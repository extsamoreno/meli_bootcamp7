package com.meli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowersUserDTO {
    private int userIdListFollowers;
    private String userNameListFollowers;
    private List<UserDTO>followersList;
}
