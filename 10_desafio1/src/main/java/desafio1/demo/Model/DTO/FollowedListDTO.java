package desafio1.demo.Model.DTO;

import lombok.Data;

@Data
public class FollowedListDTO {
    int userId;
    String userName;
    UserDTO[] followed;

    public FollowedListDTO(int userId, String userName, UserDTO[] followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }
}
