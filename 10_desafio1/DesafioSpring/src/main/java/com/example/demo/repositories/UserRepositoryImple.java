package com.example.demo.repositories;

import com.example.demo.JavaUtils;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.*;
import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.model.Product;
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
import java.util.stream.Collectors;

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
    public void follow(int userId, int userIdToFollow) throws UserAlreadyFollowException, UserDontFoundException, CantAutofollowException {
        User userR = findUserById(userId);
        User usertoFollow = findUserById(userIdToFollow);

        if(userR.equals(usertoFollow)){
            throw new CantAutofollowException(userId);
        }

        if(userR == null){
            throw new UserDontFoundException(userId);
        }else if(usertoFollow==null){
            throw new UserDontFoundException(userIdToFollow);
        }

        if(!alreadyFollow(userId,userIdToFollow)){
            int index = usersList.indexOf(userR);
            usersList.get(index).getFollowed().add(usertoFollow);
        }
    }

    @Override
    public void unfollow(int userId, int userIdToUnfollow) throws UserDontFoundException, CantUnfollowException {
        User user = findUserById(userId);
        User unfollowUser = findUserById(userIdToUnfollow);
        boolean isFollow=false;
        if(user == null){
            throw new UserDontFoundException(userId);
        }else if(unfollowUser==null){
            throw new UserDontFoundException(userId);
        }

        int index = usersList.indexOf(user);

       for(User followedUser: user.getFollowed()){
            if(followedUser.getUserId()==userIdToUnfollow){
                isFollow=true;
                user.getFollowed().remove(unfollowUser);
                usersList.set(index,user);
                break;
            }
        }
       if(!isFollow){
           throw new CantUnfollowException(user.getUserId(),unfollowUser.getUserId());
       }
    }

    @Override
    public UserFollowersCountDTO getFollowersCount(int userId) throws UserDontFoundException {
        User user = findUserById(userId);
        UserFollowersCountDTO userFollowersCountDTO;
        if(user==null){
            throw new UserDontFoundException(userId);
        }

        int count = (int) usersList.stream().filter(p->p.getFollowed().contains(user)).count();

        userFollowersCountDTO = UserMapper.toUserFollowersCountDTO(user,count);//new UserFollowersCountDTO(userR.getUserId(),userR.getUserName(),count);

        return userFollowersCountDTO;
    }

    @Override
    public UserFollowerListDTO getFollowersList(int userId, String order) throws UserDontFoundException {
        User userFollowed = findUserById(userId);
        ArrayList<UserResponseDTO> followersList= new ArrayList<>();
        UserFollowerListDTO userFollowerListDTO = new UserFollowerListDTO(userFollowed.getUserId()
                ,userFollowed.getUserName(),followersList);

       if(userFollowed==null){
           throw new UserDontFoundException(userId);
       }

        for(User user:usersList){
            for(User follower:user.getFollowed()){
                if(follower.getUserId()==userId){
                    followersList.add(new UserResponseDTO(user.getUserId(),user.getUserName()));
                }
            }
        }

        if(order.equals("name_asc")||order==null){
            userFollowerListDTO.setFollowers(new OrderAlpAsc().order(followersList));
        }else if(order.equals("name_desc")){
            userFollowerListDTO.setFollowers(new OrderAlpDesc().order(followersList));
        }

        return userFollowerListDTO;

    }

    @Override
    public UserFollowedListDTO getFollowedList(int userId,String order) throws UserDontFoundException {
        User userR = findUserById(userId);
        ArrayList<UserResponseDTO> followedList= new ArrayList<>();
        UserFollowedListDTO userFollowedListDTO = new UserFollowedListDTO(userR.getUserId(),userR.getUserName(),followedList);

        if(userR == null){
            throw new UserDontFoundException(userId);
        }

              for(User userf:userR.getFollowed()){
                  followedList.add(UserMapper.toDTO(userf));
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
    public NewPostResponseDTO newPost(NewPostRequestDTO newPostRequestDTO, Category category) throws ParseException, UserDontFoundException, InvalidDateFormatException {
        Post post;
        User user = findUserById(newPostRequestDTO.getUserId());
        int index= usersList.indexOf(user);
        post = PostMapper.toPost(newPostRequestDTO,category);
        usersList.get(index).getPosts().add(post);

        return PostMapper.toNewPostResponseDTO(newPostRequestDTO,category);
    }

    @Override
    public FollowedPostListResponseDTO getFollowedPostList(int userId,String order) throws InvalidDateFormatException {
        FollowedPostListResponseDTO followedPostListResponseDTO=null;
        ArrayList<Post> postList = new ArrayList<>();
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

        if(order.equals("date_asc")){
            followedPostListResponseDTO = PostMapper.toFollowedPostListResponseDTO(user,postList);//new FollowedPostListResponseDTO(userId,new OrderDateAsc().orderDate(postList));
        }else if(order.equals("date_desc")){
            followedPostListResponseDTO = new FollowedPostListResponseDTO(userId,new OrderDateDesc().orderDate(postList));
        }
        return followedPostListResponseDTO;
    }

    @Override
    public NewPostWithPromResponseDTO newPostWithProm(NewPostWithPromRequestDTO newPostWithPromRequestDTO, Category category) throws ParseException, InvalidDateFormatException {
        Post post;
        User user = findUserById(newPostWithPromRequestDTO.getUserId());

        int index = usersList.indexOf(user);
        post = PostMapper.toPost(newPostWithPromRequestDTO,category);
        usersList.get(index).getPosts().add(post);

        return PostMapper.toNewPostResponseDTO(newPostWithPromRequestDTO,category);
    }

    @Override
    public PostWithPromCountDTO getProductsWithPromCount(int userId) {
        PostWithPromCountDTO postWithPromCountDTO;
        User user = findUserById(userId);
        int index = usersList.indexOf(user);
        int postPromCount= (int) usersList.get(index).getPosts().stream().filter(p->p.isHasPromo()).count();//.collect(Collectors.toList());
        postWithPromCountDTO = UserMapper.toPostWithPromCount(user,postPromCount);
        return postWithPromCountDTO;
    }

    @Override
    public PostWithPromListResponseDTO getPostWithPromList(int userId) throws InvalidDateFormatException {
        PostWithPromListResponseDTO postWithPromListResponseDTO =null;
        User user = findUserById(userId);
        int index = usersList.indexOf(user);
        List<Post> postPromList = usersList.get(index).getPosts().stream().filter(p->p.isHasPromo()).collect(Collectors.toList());
        postWithPromListResponseDTO = UserMapper.toPostWithPromList(user,postPromList);
        return postWithPromListResponseDTO;
    }


}
