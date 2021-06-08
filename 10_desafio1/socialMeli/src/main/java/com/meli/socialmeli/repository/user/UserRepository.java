package com.meli.socialmeli.repository.user;

import com.meli.socialmeli.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {

    public static List<User> userList=new ArrayList<>();
    public static Integer cont=0;

    @Override
    public Optional<User> findUserById(Integer userId) {
        if (userList.isEmpty()) loadDatabase();
        return userList.stream().filter(u -> u.getUserId().equals(userId)).findFirst();
    }

    @Override
    public void save(User user) {
        if (alreadyExists(user)) this.update(user);
        else this.create(user);
    }

    private boolean alreadyExists(User user) {
        return this.findUserById(user.getUserId()).isPresent();
    }

    private void update(User user) {
        User userToRemove = this.findUserById(user.getUserId()).get();
        userList.remove(userToRemove);
        userList.add(user);
    }

    private void create(User user) {
        user.setUserId(cont);
        userList.add(user);
        cont++;
    }

    private void loadDatabase() {
        User u1569 = new User(1569, "vendedor1");
        User u4698 = new User(4698, "usuario1");
        User u1536 = new User(1536, "usuario2");
        User u2236 = new User(2236, "usuario3");
        User u6932 = new User(6932, "vendedor2");
        User u6631 = new User(6631, "vendedor3");
        User u1235 = new User(1235, "vendedor4");
        User u1456 = new User(1456, "vendedor5");
        User u1578 = new User(1578, "vendedor6");
        u4698.startToFollow(u1569);
        u4698.startToFollow(u6932);
        u4698.startToFollow(u6631);
        u1536.startToFollow(u1569);
        u2236.startToFollow(u1569);
        userList.addAll(Arrays.asList(new User[]{u1569, u4698, u1536, u2236, u6932, u6631, u1235, u1456, u1578}));
        cont = 7250;
    }


}
