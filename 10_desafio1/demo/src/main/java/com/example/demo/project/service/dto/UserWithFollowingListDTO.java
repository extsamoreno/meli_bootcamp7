package com.example.demo.project.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class UserWithFollowingListDTO extends UserWithFollowingCountDTO{
    private List<UserDTO> following;

    public UserWithFollowingListDTO(String name, int id, int following_count, List<UserDTO> following) {
        super(name, id, following_count);
        this.following = following;
    }
}
