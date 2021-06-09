package com.example.demo.repositories;

import com.example.demo.JavaUtils;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.UserAlreadyFollowException;
import com.example.demo.exceptions.UserDoesntExistException;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.services.OrderAlpAsc;
import com.example.demo.services.OrderAlpDesc;
import com.example.demo.services.OrderDateAsc;
import com.example.demo.services.OrderDateDesc;
import com.example.demo.services.mappers.PostMapper;
import com.example.demo.services.mappers.UserMapper;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImple implements UserRepository{

    private ArrayList<User> usersList = new ArrayList<User>();

    User user1 = new User(1,"User1");
    User user2 = new User(2,"vUser2");
    User user3 = new User(3,"dUser3");
    User user4 = new User(4,"aUser4");

    public void addUsers(){
        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
    }

    @Override
    public void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDoesntExistException {
        User userR = findUserById(userId);
        User usertoFollow = findUserById(userIdToFollow);
        if(userR ==null){
            throw new UserDoesntExistException(userId);
        }else if(usertoFollow==null){
            throw new UserDoesntExistException(userIdToFollow);
        }
        if(!alreadyFollow(userId,userIdToFollow)){

            for(User user:usersList){
                if(user.getUserId()==userIdToFollow){
                    usertoFollow =user;
                }
            }

            int index = 0;
            for(User user:usersList){
                if(user.getUserId()==userId){
                        usersList.get(index).getFollowed().add(usertoFollow);
                }
                index++;
            }
        }
    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) {
        User user = findUserById(userId);
        User unfollowUser = findUserById(userIdToUnfollow);

        int index = usersList.indexOf(user);

       for(User followedUser: user.getFollowed()){
            if(followedUser.getUserId()==userIdToUnfollow){
                user.getFollowed().remove(unfollowUser);
                usersList.set(index,user);
                break;
            }
        }
    }

    @Override
    public UserFollowersCountDTO getFollowersCount(int userId) throws UserDoesntExistException {
        User userR = findUserById(userId);
        UserFollowersCountDTO userFollowersCountDTO = null;
        if(userR==null){
            throw new UserDoesntExistException(userId);
        }
        for(User user:usersList){
            if(user.getUserId()==userId){
                userFollowersCountDTO = new UserFollowersCountDTO(userId,user.getUserName(),user.getFollowed().size());
                break;
            }
        }
        return userFollowersCountDTO;
    }

    @Override
    public UserFollowerListDTO getFollowersList(int userId, String order) throws UserDoesntExistException {
        User userFollowed = findUserById(userId);
        ArrayList<UserResponseDTO> followersList= new ArrayList<>();
        UserFollowerListDTO userFollowerListDTO = null;

       if(userFollowed==null){
           throw new UserDoesntExistException(userId);
       }

        for(User user:usersList){
            for(User follower:user.getFollowed()){
                if(follower.getUserId()==userId){
                    followersList.add(new UserResponseDTO(user.getUserId(),user.getUserName()));
                }
                userFollowerListDTO = new UserFollowerListDTO(userFollowed.getUserId(),userFollowed.getUserName(),followersList);
            }
        }

        if(order.equals("name_asc")){
            userFollowerListDTO.setFollowers(new OrderAlpAsc().order(followersList));
        }else if(order.equals("name_desc")){
            userFollowerListDTO.setFollowers(new OrderAlpDesc().order(followersList));
        }

        return userFollowerListDTO;

    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId,String order) throws UserDoesntExistException {
        User userR = findUserById(userId);
        ArrayList<UserResponseDTO> followedList= new ArrayList<>();
        UserFollowedListDTO userFollowedListDTO=null;

        if(userR == null){
            throw new UserDoesntExistException(userId);
        }

        for(User user:usersList){
          if(user.getUserId()==userId){
              for(User userf:user.getFollowed()){
                  followedList.add(UserMapper.toDTO(userf));
              }
              userFollowedListDTO = new UserFollowedListDTO(userId,user.getUserName(),followedList);
          }
        }
        if(order.equals("name_asc")){
            userFollowedListDTO.setFollowed(new OrderAlpAsc().order(followedList));
        }else if(order.equals("name_desc")){
            userFollowedListDTO.setFollowed(new OrderAlpDesc().order(followedList));
        }

        return userFollowedListDTO;
    }

    public boolean existUser(int userId){
        boolean exist = false;
        for(User user:usersList){
            if( user.getUserId() == userId){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public boolean alreadyFollow(int userId, int userIdToFollow) throws UserAlreadyFollowException {
       boolean exist=true;

        for(User user:usersList){
            if(user.getUserId()==userId){
                for(User userFollowed:user.getFollowed()){
                    if(userFollowed.getUserId()==userIdToFollow){
                        throw new UserAlreadyFollowException(userId,userIdToFollow);
                    }
                }
            }
        }
        return exist = false;
    }

    @Override
    public User findUserById(int userId){
        User userR = null;
        for(User user:usersList){
            if( user.getUserId() == userId){
                userR = user;
            }
        }

        if(userR == null){

        }
        return userR;
    }

    @Override
    public NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO, Category category) throws ParseException {
        Post post;
        User user = findUserById(newPostRequestDTO.getUserId());

        int index= usersList.indexOf(user);
        post = PostMapper.toPost(newPostRequestDTO,category);
        usersList.get(index).getPosts().add(post);

        return PostMapper.toNewPostResponseDTO(newPostRequestDTO,category);
    }

    @Override
    public FollowedPostListResponseDTO getFollowedPostList(int userId,String order){
        FollowedPostListResponseDTO followedPostListResponseDTO=null;
        List<Post> postList = new ArrayList<>();
        User user = findUserById(userId);

        int index= usersList.indexOf(user);

        for(User followed:usersList.get(index).getFollowed()){
                for(Post post:followed.getPosts()){
                    LocalDate today = LocalDate.now();
                    LocalDate postDate = JavaUtils.convertToLocalDateViaInstant(post.getDate());
                    int daysBetween = JavaUtils.daysDifference(today, postDate);

                    if(daysBetween>=0 && daysBetween<=14){
                        postList.add(post);
                    }
                }
        }

        followedPostListResponseDTO = PostMapper.toFollowedPostListResponseDTO(user,postList);
        if(order.equals("name_asc")){
            followedPostListResponseDTO= new OrderDateAsc().order(followedPostListResponseDTO);
        }else if(order.equals("name_desc")){
            followedPostListResponseDTO= new OrderDateDesc().order(followedPostListResponseDTO);
        }
        return followedPostListResponseDTO;
    }


}
