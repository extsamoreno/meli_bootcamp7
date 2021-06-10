package desafio1.demo.Model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
public class User {
    int userId;
    String userName;
    List<User> followedUsersList = new ArrayList<>();
    List<Post> postList = new ArrayList<>();

    public User(int userId, String userName, List<User> followedUsersList) {
        this.userId = userId;
        this.userName = userName;
        this.followedUsersList = followedUsersList;
    }
}
