package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.exception.*;
import com.api.socialmeli.model.PostModel;
import com.api.socialmeli.model.UserModel;
import com.api.socialmeli.repository.PostRepositoryImple;
import com.api.socialmeli.repository.UserRepositoryImple;
import com.api.socialmeli.service.mapper.PostMapper;
import com.api.socialmeli.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor @NoArgsConstructor
public class SocialMeliServiceImple implements SocialMeliService {

@Autowired
UserRepositoryImple userRepositoryImple;
@Autowired
PostRepositoryImple postRepositoryImple;

    @Override
    public String US001(Integer userId, Integer userIdToFollow) throws Exception {

        if (userId.equals(userIdToFollow)) throw new EqualsIdException();

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);
        if (userRepositoryImple.getUsers().get(userIdToFollow)==null) throw new NotFoundIdException(userId);

        UserModel follower = userRepositoryImple.getUsers().get(userId);
        userRepositoryImple.getUsers().get(userIdToFollow).getFollowers().add(follower);

        UserModel followed = userRepositoryImple.getUsers().get(userIdToFollow);
        userRepositoryImple.getUsers().get(userId).getFollowed().add(followed);

        return "user: " + userId + " follows user: " + userIdToFollow;
    }

    @Override
    public FollowersCountDTO US002(Integer userId) throws Exception {

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        String userName = userRepositoryImple.getUsers().get(userId).getUserName();
        Integer followersCount=userRepositoryImple.getUsers().get(userId).getFollowers().size();
        return new FollowersCountDTO(userId, userName, followersCount);
    }

    @Override
    public FollowersDTO US003(int userId, String order) throws Exception {

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);
        UserModel user = userRepositoryImple.getUsers().get(userId);
        FollowersDTO dto = new FollowersDTO();
        dto.setUserId(userId);
        dto.setUserName(user.getUserName());
        ArrayList<UserDTO> followers= new ArrayList<>();

        for (UserModel u : user.getFollowers())
            followers.add(UserMapper.userToFollowerDTO(u));

        if (order!=null){
            if (order.equals("name_asc")){
                List<UserDTO> sortedList =  followers.stream()
                        .sorted((o1, o2) -> { return o1.getUserName().compareTo(o2.getUserName()); })
                        .collect(Collectors.toList());

                followers= (ArrayList<UserDTO>) sortedList;
            }
            if (order.equals("name_desc")){
                List<UserDTO> sortedList =  followers.stream()
                        .sorted((o1, o2) -> { return o2.getUserName().compareTo(o1.getUserName()); })
                        .collect(Collectors.toList());

                followers= (ArrayList<UserDTO>) sortedList;
            }

        }

        dto.setFollowers(followers);
        return dto;

    }

    @Override
    public UserFolowedDTO US004(int userId, String order) throws Exception {

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        UserModel user = userRepositoryImple.getUsers().get(userId);
        UserFolowedDTO dto = new UserFolowedDTO();
        dto.setUserId(userId);
        dto.setUserName(user.getUserName());

        ArrayList<UserDTO> followed= new ArrayList<>();

        for (UserModel u : user.getFollowed())
            followed.add(UserMapper.userToFollowerDTO(u));

        if (order!=null){
            if (order.equals("name_asc")){
                List<UserDTO> sortedList =  followed.stream()
                        .sorted((o1, o2) -> { return o1.getUserName().compareTo(o2.getUserName()); })
                        .collect(Collectors.toList());

                followed= (ArrayList<UserDTO>) sortedList;
            }
            if (order.equals("name_desc")){
                List<UserDTO> sortedList =  followed.stream()
                        .sorted((o1, o2) -> { return o2.getUserName().compareTo(o1.getUserName()); })
                        .collect(Collectors.toList());

                followed= (ArrayList<UserDTO>) sortedList;
            }

        }

        dto.setFollowed(followed);
        return dto;

    }

    @Override
    public String US005(PostDTO newPost ) throws Exception{

        if (userRepositoryImple.getUsers().get(newPost.getUserId())==null) throw new NotFoundIdException(newPost.getUserId());
        List<PostModel> postlist = postRepositoryImple.getDbPosts();

        for (int i = 0; i <postlist.size() ; i++) {
            if (postlist.get(i).getId_post()==newPost.getId_post()) throw new PostIdExistsException();
        }

        postRepositoryImple.getDbPosts().add(PostMapper.dtoToModel(newPost));

        return "new post created";
    }

    @Override
    public FollowedPostsDTO US006(int userId , String order) throws Exception{

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        FollowedPostsDTO followedPosts = new FollowedPostsDTO();
        followedPosts.setUserId(userId);
        //Load all Posts
        followedPosts.setPosts(postRepositoryImple.getDbPosts());
        //Load Users Followed
        List<UserModel> followed = userRepositoryImple.getUsers().get(userId).getFollowed();
        List<PostModel> postlist = new ArrayList<>();
        // Select posts by user ID
        for (int i = 0; i < followed.size(); i++) {
            for (int j = 0; j < followedPosts.getPosts().size(); j++) {
                if (followed.get(i).getUserId()==followedPosts.getPosts().get(j).getUserId()){
                    postlist.add(followedPosts.getPosts().get(j));
                }
            }
        }
        followedPosts.setPosts(postlist);

        // Delete Old Posts
        List<PostModel> auxList = new ArrayList<>();
        LocalDate dateOfTwoWeeks= LocalDate.now().minusWeeks(2);
        for (int i = 0; i < followedPosts.getPosts().size(); i++) {
            if (followedPosts.getPosts().get(i).getDate().isAfter(dateOfTwoWeeks)){
                auxList.add(followedPosts.getPosts().get(i));
            }
        }
        followedPosts.setPosts(auxList);

        // Sort Posts by Day
        List<PostModel> sortedList = followedPosts.getPosts().stream()
                .sorted((o1, o2) -> { return o1.getDate().compareTo(o2.getDate()); })
                .collect(Collectors.toList());
        followedPosts.setPosts(sortedList);

        if (order!= null){
            if (order.equals("date_asc")){
                followedPosts.setPosts(sortedList);
            }
            if (order.equals("date_desc")){
                List<PostModel> descSorterList = new ArrayList<>();
                for (int i = 0; i < sortedList.size(); i++) {
                    descSorterList.add(sortedList.get(sortedList.size()-1-i));
                }
                followedPosts.setPosts(descSorterList);
            }
        }

        return followedPosts;
    }

    @Override
    public String US007(int userId, int userIdToUnfollow) throws Exception{

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);
        if (userRepositoryImple.getUsers().get(userIdToUnfollow)==null) throw new NotFoundIdException(userIdToUnfollow);

        ArrayList <UserModel> followedList = userRepositoryImple.getUsers().get(userId).getFollowed();
        ArrayList <UserModel> followerList = userRepositoryImple.getUsers().get(userIdToUnfollow).getFollowers();

        ArrayList <UserModel> auxList1 = new ArrayList<>();
        for (int i = 0; i < followedList.size(); i++) {
            if (followedList.get(i).getUserId()!=userIdToUnfollow){
                auxList1.add(followedList.get(i));
            }
        }

        if (auxList1.size()==followedList.size()) throw new IsNotaFollowerException(userId,userIdToUnfollow);

        ArrayList <UserModel> auxList2 = new ArrayList<>();
        for (int i = 0; i < followerList.size(); i++) {
            if (followerList.get(i).getUserId()!=userId){
                auxList2.add(followerList.get(i));
            }
        }

        userRepositoryImple.getUsers().get(userId).setFollowed(auxList1);
        userRepositoryImple.getUsers().get(userIdToUnfollow).setFollowers(auxList2);

        return "user: " + userId + " unfollows: " + userIdToUnfollow;

    }

}
