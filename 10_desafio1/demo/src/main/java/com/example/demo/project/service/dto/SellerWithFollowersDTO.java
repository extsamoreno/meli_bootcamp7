package com.example.demo.project.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@NoArgsConstructor
public class SellerWithFollowersDTO extends SellerDTO {
    private List<UserDTO> followers;

    public SellerWithFollowersDTO(String name, int id, int followers_count, List<UserDTO> followers) {
        super(name, id, followers_count);
        this.followers = followers;
    }
}
