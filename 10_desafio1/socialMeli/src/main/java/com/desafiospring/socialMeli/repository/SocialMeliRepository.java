package com.desafiospring.socialMeli.repository;

import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.exceptions.PostIdAlreadyExistException;
import com.desafiospring.socialMeli.exceptions.UserAlreadyFollowsException;
import com.desafiospring.socialMeli.exceptions.UserAlreadyUnfollowsException;
import com.desafiospring.socialMeli.exceptions.UserNotFoundException;
import com.desafiospring.socialMeli.model.Post;
import com.desafiospring.socialMeli.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {
    HashMap<Integer, User> usersDic = new HashMap<>();
    private List<Post> posts = new ArrayList<>();

    public SocialMeliRepository() {
        usersDic.put(1, new User("Roberto", 1, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(2, new User("Sofia", 2, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(3, new User("Laura", 3, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(4, new User("Susana", 4, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(5, new User("Ximena", 5, new ArrayList<>(), new ArrayList<>()));
        usersDic.put(6, new User("Usuario6", 6, new ArrayList<>(), new ArrayList<>()));
    }

    @Override
    public User findUserById(int userId) throws UserNotFoundException {
        if (usersDic.get(userId) == null) {
            throw new UserNotFoundException(userId);
        }
        return usersDic.get(userId);
    }

    @Override
    public void addFollowerToUser(int userId, int userIdToFollow)
            throws UserNotFoundException, UserAlreadyFollowsException {
        User user = findUserById(userId);
        User userToFollow = findUserById(userIdToFollow);

        if (user.getFollowed().contains(userToFollow)) {
            throw new UserAlreadyFollowsException(userId, userIdToFollow);
        } else {
            usersDic.get(userId).getFollowed().add(findUserById(userIdToFollow));
            usersDic.get(userIdToFollow).getFollowedBy().add(findUserById(userId));
        }
    }

    @Override
    public int getFollowersCount(int userId) {

        return usersDic.get(userId).getFollowedBy().size();
    }

    @Override
    public List<User> getFollowersList(int userId) throws UserNotFoundException {
        User user = findUserById(userId);
        List<User> followersList = new ArrayList<>();
        for (User u : user.getFollowedBy()) {
            followersList.add(u);
        }
        return followersList;

    }

    @Override
    public List<User> getFollowedList(int userId) throws UserNotFoundException {

        User user = findUserById(userId);
        List<User> followedList = new ArrayList<>();
        for (User u : user.getFollowed()) {
            followedList.add(u);
        }

        return followedList;

    }

    @Override
    public void deleteFollower(int userId, int userIdToFollow)
            throws UserNotFoundException, UserAlreadyUnfollowsException {
        User user = findUserById(userId);
        User userToFollow = findUserById(userIdToFollow);

        if (user.getFollowed().contains(userToFollow)) {
            usersDic.get(userId).getFollowed().remove(findUserById(userIdToFollow));
            usersDic.get(userIdToFollow).getFollowedBy().remove(findUserById(userId));

        } else {
            throw new UserAlreadyUnfollowsException(userId, userIdToFollow);
        }
    }


    @Override
    public void addNewPost(Post post) throws PostIdAlreadyExistException {

        Post checkPost = this.posts.stream()
                .filter(p -> p.getId_post() == post.getId_post())
                .findAny().orElse(null);

        if (checkPost != null) {
            throw new PostIdAlreadyExistException(post.getId_post());
        } else {
            this.posts.add(post.getId_post(), post);
        }

    }

    @Override
    public List<Post> getFollowedPosts(List<User> followed, String order) {
        List<Post> followedPosts = new ArrayList<>();

        for (User u : followed) {
            followedPosts.addAll(getPosts(u.getUserId()));
        }

        if(order != null && order.equals("date_asc"))
            followedPosts.sort(Comparator.comparing(Post::getDate));

        if(order != null && order.equals("date_desc"))
            followedPosts.sort(Comparator.comparing(Post::getDate).reversed());

        return followedPosts;
    }

    private List<Post> getPosts(Integer userId) {
        return this.posts.stream()
                .filter(i -> i.getUserId() == (userId))
                .filter(i -> i.getDate().after(getDateBefore15days()))
                .collect(Collectors.toList());
    }

    private Date getDateBefore15days() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }


}