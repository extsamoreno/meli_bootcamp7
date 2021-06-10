package meli.social.service.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class UserFollowersListDTO extends UserDTO{
    private List<UserDTO> followers;

    public UserFollowersListDTO(int userId, String nombre, List<UserDTO> followers) {
        super(userId, nombre);
        this.followers = followers;
    }
}
