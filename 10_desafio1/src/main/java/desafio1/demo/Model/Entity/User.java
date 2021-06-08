package desafio1.demo.Model.Entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class User {
    int userId;
    String userName;
    List<User> followedUsersList = new ArrayList<User>();

    public User(int userId, String userName, List<User> followedUsersList) {
        this.userId = userId;
        this.userName = userName;
        this.followedUsersList = followedUsersList;
    }
}
