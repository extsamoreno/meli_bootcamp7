package com.meli.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithPromoCountDTO extends UserDTO {
    private Integer promoproducts_count;

    public UserWithPromoCountDTO(Integer userId, String username, Integer promoproducts_count) {
        super(userId, username);
        this.promoproducts_count = promoproducts_count;
    }
}
