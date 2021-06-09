package com.example.challenge.Repositories;

import com.example.challenge.Exceptions.PostDuplicateException;
import com.example.challenge.Exceptions.UserNotFoundException;
import com.example.challenge.Models.Post;
import com.example.challenge.Models.Product;
import com.example.challenge.Models.User;
import com.example.challenge.Services.DTOs.FollowDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {

    private HashMap<Integer, User> users = new HashMap<>();


    @Override
    public FollowDTO follow(int followerId, int followedId) throws UserNotFoundException {
        User followed = this.users.get(followedId);
        User follower = this.users.get(followerId);

        followed.addFollower(follower);
        follower.addFollowed(followed);

        return new FollowDTO(followedId, followerId, "Follow");
    }

    public User findUserById(int userId) throws UserNotFoundException {

        try {
            return this.users.get(userId);
        } catch (Exception e) {
            throw new UserNotFoundException(userId);
        }
    }

    public List<User> getUsers() {
        List<User> res = new ArrayList<>();
        for (Map.Entry<Integer, User> u : this.users.entrySet()) {
            res.add(u.getValue());
        }
        return res;
    }


    @Override
    public void addPost(Post post) throws UserNotFoundException, PostDuplicateException {
        List<Post> postList = findUserById(post.getUserId()).getPosts();
        if (postList.stream().anyMatch(p -> p.getId() == post.getId())) {
            throw new PostDuplicateException(post.getId());
        }
        postList.add(post);

    }


    public String addUser(String userName) {
        int id = this.users.size() + 1;
        User newUser = new User();
        newUser.setName(userName);
        newUser.setId(id);
        newUser.setFollowed(new ArrayList<>());
        newUser.setFollowers(new ArrayList<>());
        newUser.setPosts(new ArrayList<>());
        this.users.put(id, newUser);
        return newUser.getName();
    }

    @Override
    public void loadData() throws UserNotFoundException, PostDuplicateException {
        this.users.put(1, new User(1, "Ana", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(2, new User(2, "Juan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(3, new User(3, "Pablo", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(4, new User(4, "Lucia", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(5, new User(5, "Sebastian", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(6, new User(6, "Amelia", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(7, new User(7, "Franco", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        this.users.put(8, new User(8, "Diego", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        addPost(new Post(1, 1, LocalDate.now(), new Product(1, "prod1", "type1", "brand1", "Color1", "bla", false, 0), 123, 232));
        addPost(new Post(1, 2, LocalDate.now().minusDays(2), new Product(2, "prod2", "type2", "brand2", "Color2", "bla", false, 0), 123, 232));
        addPost(new Post(1, 3, LocalDate.now().minusDays(5), new Product(3, "prod3", "type3", "brand3", "Color3", "bla", false, 0), 123, 232));
        addPost(new Post(3, 1, LocalDate.now().minusDays(45), new Product(1, "prod1", "type1", "brand1", "Color1", "bla", false, 0), 123, 232));
        addPost(new Post(4, 1, LocalDate.now().minusDays(1), new Product(1, "prod1", "type1", "brand1", "Color1", "bla", false, 0), 123, 232));
        addPost(new Post(1, 4, LocalDate.now().minusDays(13), new Product(4, "prod1", "type1", "brand1", "Color1", "bla", false, 0), 123, 232));
    }

    @Override
    public FollowDTO unfollow(int followerId, int followedId) throws UserNotFoundException {
        User followed = this.users.get(followedId);
        User follower = this.users.get(followerId);

        followed.getFollowers().remove(follower);
        follower.getFollowed().remove(followed);

        return new FollowDTO(followedId, followerId, "Unfollow");
    }


}
