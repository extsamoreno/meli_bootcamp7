package com.meli.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithFollowersCountDTO extends UserDTO {
    private Integer followers_count;

    public UserWithFollowersCountDTO(Integer userId, String username, Integer followers_count) {
        super(userId, username);
        this.followers_count = followers_count;
    }
}
