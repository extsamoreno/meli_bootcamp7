package com.springChallenge.api.repository.implementation;

import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.aux.DbLoader;
import com.springChallenge.api.repository.contract.IUserRepository;
import com.springChallenge.api.repository.entity.Post;
import com.springChallenge.api.repository.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository {
    private final ArrayList<User> users = DbLoader.loadUsers();

    /**
     * returns an user given his id
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public User getByUserId(int userId) throws UserNotFoundException {
        Optional<User> user = users.stream().filter(x -> x.getUserId() == userId).findFirst();
        if (user.isPresent())
            return user.get();
        else
            throw new UserNotFoundException(userId);
    }

    /**
     * creates a new user in DB or update the already existing user
     * @param user
     */
    @Override
    public void save(User user) {
        var userInDb = users.stream().filter(x -> x.getUserId() == user.getUserId()).findFirst();
        if (userInDb.isPresent())
            update(userInDb.get(), user);
        else
            users.add(user);
    }

    /**
     * gets all the posts by all the sellers followed by a user
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
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

    /**
     * gets all the posts that includes hasPromo == true by a given userId
     * @param userId
     * @return
     * @throws UserNotFoundException
     */
    @Override
    public ArrayList<Post> getPromoPostsById(Integer userId) throws UserNotFoundException {
        var user = getByUserId(userId);
        return user
                .getPosts()
                .stream().filter(Post::isHasPromo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * returns all the posts within two weeks from today
     * @param posts
     * @return
     */
    private ArrayList<Post> getPostsWithinTwoWeeks(ArrayList<Post> posts) {
        LocalDate localDate = LocalDate.now();
        return posts
                .stream()
                .filter(x -> x.getDate().isAfter(localDate.minusWeeks(2)) && x.getDate().isBefore(localDate.plusDays(1)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * copy all the values to a given user
     * @param userInDb
     * @param user
     */
    private void update(User userInDb, User user){
        userInDb.copyAll(user);
    }
}
