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
public class UserWithFollowedDTO extends UserDTO {
    private List<UserDTO> followed;

    public UserWithFollowedDTO(Integer userId, String username, List<UserDTO> followed) {
        super(userId, username);
        this.followed = followed;
    }

}
