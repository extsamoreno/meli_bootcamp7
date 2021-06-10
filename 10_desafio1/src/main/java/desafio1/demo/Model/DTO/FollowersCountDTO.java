package desafio1.demo.Model.DTO;

import lombok.Data;

@Data
public class FollowersCountDTO {
    int userId;
    String userName;
    long followers_count;

    public FollowersCountDTO(int userId, String userName, long followers_count) {
        this.userId = userId;
        this.userName = userName;
        this.followers_count = followers_count;
    }
}
