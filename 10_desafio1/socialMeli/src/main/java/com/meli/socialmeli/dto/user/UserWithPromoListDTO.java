package com.meli.socialmeli.dto.user;

import com.meli.socialmeli.dto.product.PublicationWithPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithPromoListDTO extends UserDTO {
    private List<PublicationWithPromoDTO> posts;

    public UserWithPromoListDTO(Integer userId, String username, List<PublicationWithPromoDTO> posts) {
        super(userId, username);
        this.posts = posts;
    }

}
