package desafio1.demo.Model.DTO;

import lombok.Data;

import java.util.List;

@Data
public class FollowersListDTO {
    int userId;
    String userName;
    UserDTO[] followers;

    public FollowersListDTO(int userId, String userName, UserDTO[] followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }
}
