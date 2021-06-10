package com.example.demo.project.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class UserWithFollowingListDTO extends UserWithFollowingCountDTO{
    private List<UserDTO> followed;

    public UserWithFollowingListDTO(String name, int id, int following_count, List<UserDTO> followed) {
        super(name, id, following_count);
        this.followed = followed;
    }
}
