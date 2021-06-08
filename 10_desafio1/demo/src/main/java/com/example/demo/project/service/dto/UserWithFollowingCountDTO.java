package com.example.demo.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithFollowingCountDTO extends UserDTO{
    private int following_count;

    public UserWithFollowingCountDTO(String name, int id, int following_count) {
        super(name, id);
        this.following_count = following_count;
    }
}
