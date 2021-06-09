package com.example.demo.repository;

import com.example.demo.DTO.PostDTO;
import com.example.demo.DTO.PostListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.FollowersNotFoundException;
import com.example.demo.exception.GenericException;
import com.example.demo.exception.UserNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class GeneralRepository implements IGeneralRepository {

    private HashMap<Integer, List<UserDTO>> followerDB;
    private HashMap<Integer, List<UserDTO>> followedDB;
    private HashMap<Integer, List<PostDTO>> postDB;

    public GeneralRepository(){
        this.followedDB = new HashMap<>();
        this.followerDB = new HashMap<>();
        this.postDB = new HashMap<>();
    }

    @Override
    public void follow(UserDTO userId, UserDTO userIdToFollow){
        addFollower(userId, userIdToFollow);
        addFollowed(userId, userIdToFollow);
    }

    @Override
    public UserDTO findById(Integer userId) throws UserNotFoundException {
        List<UserDTO> user = null;
        user = LoadDataBase();
        UserDTO result = null;
        if (user != null) {
            Optional<UserDTO> item = user.stream()
                    .filter(id -> id.getUserId().intValue() == userId.intValue())
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }
        if (result == null)
            throw new UserNotFoundException(userId);
        return result;
    }

    @Override
    public Integer countFollowers(UserDTO user) {
        List<UserDTO> followerList  = this.followerDB.get(user.getUserId());
        return (followerList == null ? 0:followerList.size());
    }

    @Override
    public List<UserDTO> followersList(Integer userId) {
        List<UserDTO> followersList = this.followerDB.get(userId);
        return (followersList == null?new ArrayList<>():followersList);
    }

    @Override
    public List<UserDTO> followedList(Integer userID) {
        List<UserDTO> followedList = this.followedDB.get(userID);
        return (followedList == null?new ArrayList<>():followedList);
    }

    @Override
    public void newPost(PostDTO post) {
        if (this.postDB.containsKey(post.getUserId()))
            this.postDB.get(post.getUserId()).add(post);
        else{
            List<PostDTO> listPost = new ArrayList<>();
            listPost.add(post);
            this.postDB.put(post.getUserId(),listPost);
        }
    }

    @Override
    public List<PostDTO> findPostByUserId(Integer userId) {
        return (this.postDB.get(userId) == null ? new ArrayList<>():this.postDB.get(userId));
    }

    @Override
    public void unfollow(UserDTO userId, UserDTO userIdToUnfollow) throws GenericException {
        lessFollower(userId,userIdToUnfollow);
        lessFollowed(userId,userIdToUnfollow);
    }

    private void addFollowed(UserDTO userId, UserDTO userIdToFollow) {
        if(this.followedDB.containsKey(userId.getUserId())){
            this.followedDB.get(userId.getUserId()).add(userIdToFollow);
        }else{
            List<UserDTO> listFollower = new ArrayList<>();
            listFollower.add(userIdToFollow);
            this.followedDB.put(userId.getUserId(),listFollower);
        }
    }

    private void addFollower(UserDTO userId, UserDTO userIdToFollow) {
        if(this.followerDB.containsKey(userIdToFollow.getUserId())){
            this.followerDB.get(userIdToFollow.getUserId()).add(userId);
        }else{
            List<UserDTO> listFollowed = new ArrayList<>();
            listFollowed.add(userId);
            this.followerDB.put(userIdToFollow.getUserId(),listFollowed);
        }
    }

    private void lessFollowed(UserDTO userId, UserDTO userIdToUnfollow) throws FollowersNotFoundException {
        if (this.followedDB.containsKey(userId.getUserId())){
            List<UserDTO> listFollowed = this.followedDB.get(userId.getUserId());
            Integer index = IntStream.range(0,listFollowed.size())
                    .filter(a -> listFollowed.get(a).getUserId().intValue() == userIdToUnfollow.getUserId().intValue())
                    .findFirst().orElse(-1);
            if(index == -1)
                throw new FollowersNotFoundException(userId.getUserId(),userIdToUnfollow.getUserId());
            listFollowed.remove(index);
            this.followedDB.get(userId.getUserId()).remove(index.intValue());
        }else{
            throw new FollowersNotFoundException(userId.getUserId(),userIdToUnfollow.getUserId());
        }
    }

    private void lessFollower(UserDTO userId, UserDTO userIdToUnfollow) throws GenericException {
        if (this.followerDB.containsKey(userIdToUnfollow.getUserId())){
            List<UserDTO> listFollower = this.followerDB.get(userIdToUnfollow.getUserId());
            Integer index = IntStream.range(0,listFollower.size())
                    .filter(a -> listFollower.get(a).getUserId().intValue() == userId.getUserId().intValue())
                    .findFirst().orElse(-1);
            if(index == -1)
                throw new FollowersNotFoundException(userId.getUserId(),userIdToUnfollow.getUserId());
            this.followerDB.get(userIdToUnfollow.getUserId()).remove(index.intValue());
        }else{
            throw new FollowersNotFoundException(userId.getUserId(),userIdToUnfollow.getUserId());
        }
    }


    private List<UserDTO> LoadDataBase() {
        File file = null;
        String fuenteArchivo = "src/main/java/com/example/demo/repository/user.json";
        try {
            file = ResourceUtils.getFile(fuenteArchivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<UserDTO>> typeRef = new TypeReference<>() {};
        List<UserDTO> user = null;
        try {
            user = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
