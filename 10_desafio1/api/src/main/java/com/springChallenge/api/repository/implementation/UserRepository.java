package com.springChallenge.api.repository.implementation;

import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.aux.DbLoader;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.repository.entity.Post;
import com.springChallenge.api.repository.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private final ArrayList<User> users = DbLoader.loadUsers();

    @Override
    public User getByUserId(int userId) throws UserNotFoundException {
        Optional<User> user = users.stream().filter(x -> x.getUserId() == userId).findFirst();
        if (user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException(userId);
    }

    @Override
    public void save(User user) {
        var userInDb = users.stream().filter(x -> x.getUserId() == user.getUserId()).findFirst();
        if (userInDb.isPresent())
            update(userInDb.get(), user);
        else
            users.add(user);
    }

    @Override
    public ArrayList<Post> getFollowedPosts(int userId) throws UserNotFoundException {
        var user = getByUserId(userId);
        ArrayList<Post> posts = new ArrayList<>();
        for (User userFollowed : user.getSellersFollowed()){
            ArrayList<Post> postsWithinTwoWeeks = getPostsWithinTwoWeeks(userFollowed.getPosts());
            posts.addAll(postsWithinTwoWeeks);
        }
        return posts;
    }

    private ArrayList<Post> getPostsWithinTwoWeeks(ArrayList<Post> posts) {
        LocalDate localDate = LocalDate.now();
        return posts
                .stream()
                .filter(x -> x.getDate().isAfter(localDate.minusWeeks(2)) && x.getDate().isBefore(localDate.plusDays(1)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void update(User userInDb, User user){
        userInDb.copyAll(user);
    }
}
