package desafio1.demo.Repository;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.Entity.Post;
import desafio1.demo.Model.Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    HashMap<Integer, User> userDict = new HashMap<>();

    //Dummy data to initialize the HashMap
    public Repository() {
        this.userDict.put(0,new User(0,"user0", new ArrayList<>()));
        this.userDict.put(1,new User(1,"user1", new ArrayList<>()));
        this.userDict.put(2,new User(2,"user2", new ArrayList<>()));
        this.userDict.put(3,new User(3,"user3", new ArrayList<>()));
        this.userDict.put(4,new User(4,"user4", new ArrayList<>()));
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        var user = userDict.get(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    @Override
    public Stream<User> getUserFollowersById(int userId) throws UserNotFoundException {
        var user = this.getUserById(userId);
        return this.userDict.values().stream()
                .filter(u -> u.getFollowedUsersList().contains(user));
    }

    @Override
    public Stream<Post> getUserPromoPostsById(int userId) throws UserNotFoundException {
        return this.getUserById(userId).getPostList().stream().filter(Post::isHasPromo);
    }

    @Override
    public void addNewPost(Post newPost) throws UserNotFoundException, DuplicatePostIdException {
        var postList = this.getUserById(newPost.getUserId()).getPostList();
        if (postList.stream().anyMatch(post -> post.getId_post() == newPost.getId_post())){
            throw new DuplicatePostIdException(newPost.getId_post());
        }
        postList.add(newPost);
    }


}
