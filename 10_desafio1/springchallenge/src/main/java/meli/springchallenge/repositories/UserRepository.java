package meli.springchallenge.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.springchallenge.dtos.UserDTO;
import meli.springchallenge.exceptions.RelationNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.models.User;
import meli.springchallenge.models.UserRelation;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository{

    private List<User> users = loadUserDB();
    private List<UserRelation> usersRelations = new ArrayList<>();
    private int counterRelations = 0;
    private int counterUsers = users.size();

    @Override
    public void addFollower(int follower, int following) throws UserNotValidException, RelationNotValidException {

        boolean followerIsValid = validateUser(follower);
        boolean followingIsValid = validateUser(following);

        validateRelation(follower, following);

        if(followerIsValid && followingIsValid){
            counterRelations++;
            usersRelations.add(new UserRelation(counterRelations, follower, following, new Date()));
        }
    }

    @Override
    public User getUserById(int userId) throws UserNotValidException {
        for(User u:users){
            if(u.getUserId() == userId){
                return u;
            }
        }
        throw new UserNotValidException(userId);
    }

    @Override
    public int countFollowers(int userId) {
        int count = 0;
        for(UserRelation r:usersRelations){
            if(r.getFollowing() == userId){
                count++;
            }
        }
        return count;
    }

    @Override
    public List<User> getFollowers(int userId) {
        List<User> followers = new ArrayList<>();
        for(UserRelation r:usersRelations){
            if(r.getFollowing()==userId){
                try{
                    followers.add(this.getUserById(r.getFollower()));
                }catch (UserNotValidException e) {
                    e.printStackTrace();
                }
            }
        }
        return followers;
    }

    @Override
    public List<User> getFollowed(int userId) {
        List<User> followed = new ArrayList<>();
        for(UserRelation r:usersRelations){
            if(r.getFollower()==userId){
                try{
                    followed.add(this.getUserById(r.getFollowing()));
                }catch (UserNotValidException e) {
                    e.printStackTrace();
                }
            }
        }
        return followed;
    }

    private boolean validateUser( int userId) throws UserNotValidException {

        for(User u:users){
            if(u.getUserId() == userId){
                return true;
            }
        }
        throw new UserNotValidException(userId);
    }

    private void validateRelation (int followerId, int followingId) throws RelationNotValidException {

        if(followerId == followingId){
            throw new RelationNotValidException(followerId, followingId);
        }

        for(UserRelation r:usersRelations){
            if(r.getFollower() == followerId && r.getFollowing() == followingId){
                throw new RelationNotValidException(followerId, followingId);
            }
        }

    }



    private List<User> loadUserDB() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {};

        List<User> db = null;

        try {
            db = objectMapper.readValue(file, typeRef);
        } catch (IOException e){
            e.printStackTrace();
        }
        return db;
    }
}
