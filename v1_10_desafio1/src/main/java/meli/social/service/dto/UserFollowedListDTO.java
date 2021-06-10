package meli.social.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class UserFollowedListDTO extends UserDTO{
    private List<UserDTO> followed;

    public UserFollowedListDTO(int userId, String nombre, List<UserDTO> followed) {
        super(userId, nombre);
        this.followed = followed;
    }
}
