package meli.social.service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class UserFollowersCounterDTO extends UserDTO{
    private int followersCounter;

    public UserFollowersCounterDTO(int userId, String nombre, int followersCounter) {
        super(userId, nombre);
        this.followersCounter = followersCounter;
    }
}
