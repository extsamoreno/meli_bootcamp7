package com.meli.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithFollowersDTO extends UserDTO {
    private List<UserDTO> followers;

    public UserWithFollowersDTO(Integer userId, String username, List<UserDTO> followers) {
        super(userId, username);
        this.followers = followers;
    }
}
