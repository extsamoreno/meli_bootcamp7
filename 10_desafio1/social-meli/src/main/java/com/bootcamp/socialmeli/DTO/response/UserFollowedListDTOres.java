package com.bootcamp.socialmeli.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowedListDTOres {
    private Integer userId;
    private String userName;
    private List<UserDTOres> followed;
}
