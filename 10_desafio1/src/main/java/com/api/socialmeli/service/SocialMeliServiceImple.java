package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;
import com.api.socialmeli.exception.*;
import com.api.socialmeli.model.PostModel;
import com.api.socialmeli.model.UserModel;
import com.api.socialmeli.repository.PostRepositoryImple;
import com.api.socialmeli.repository.UserRepositoryImple;
import com.api.socialmeli.service.mapper.PostMapper;
import com.api.socialmeli.service.mapper.UserMapper;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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

    @Override //US 0001: Follow a user
    public String US001(Integer userId, Integer userIdToFollow) throws Exception {

        if (userId.equals(userIdToFollow)) throw new EqualsIdException();
        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);
        if (userRepositoryImple.getUsers().get(userIdToFollow)==null) throw new NotFoundIdException(userId);

        UserModel follower = userRepositoryImple.getUsers().get(userId);
        userRepositoryImple.getUsers().get(userIdToFollow).getFollowers().add(follower);

        UserModel followed = userRepositoryImple.getUsers().get(userIdToFollow);
        userRepositoryImple.getUsers().get(userId).getFollowed().add(followed);

        return "Success! user: " + userId + " follows user: " + userIdToFollow;
    }

    @Override //US 0002: Followers count
    public FollowersCountDTO US002(Integer userId) throws Exception {

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        String userName = userRepositoryImple.getUsers().get(userId).getUserName();
        Integer followersCount=userRepositoryImple.getUsers().get(userId).getFollowers().size();
        return new FollowersCountDTO(userId, userName, followersCount);
    }

    @Override //US 0003: Followers list - US 0008: Sort by name alphabetically ascending and descending
    public FollowersDTO US003(int userId, String order) throws Exception {

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        UserModel user = userRepositoryImple.getUsers().get(userId);
        FollowersDTO dto = new FollowersDTO();
        dto.setUserId(userId);
        dto.setUserName(user.getUserName());
        ArrayList<UserDTO> followers= new ArrayList<>();

        for (UserModel u : user.getFollowers())
            followers.add(UserMapper.userToFollowerDTO(u));

        if (order!=null){ //check for param
            if (order.equals("name_asc")){ //Sort by name ascending
                List<UserDTO> sortedList =  followers.stream()
                        .sorted((o1, o2) -> { return o1.getUserName().compareTo(o2.getUserName()); })
                        .collect(Collectors.toList());

                followers= (ArrayList<UserDTO>) sortedList;
            }
            if (order.equals("name_desc")){ //Sort by name descending
                List<UserDTO> sortedList =  followers.stream()
                        .sorted((o1, o2) -> { return o2.getUserName().compareTo(o1.getUserName()); })
                        .collect(Collectors.toList());

                followers= (ArrayList<UserDTO>) sortedList;
            }
        }

        dto.setFollowers(followers);
        return dto;

    }

    @Override //US 0004: Followed list - US 0008: Sort by name alphabetically ascending and descending
    public UserFolowedDTO US004(int userId, String order) throws Exception {

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        UserModel user = userRepositoryImple.getUsers().get(userId);
        UserFolowedDTO dto = new UserFolowedDTO();
        dto.setUserId(userId);
        dto.setUserName(user.getUserName());

        ArrayList<UserDTO> followed= new ArrayList<>();

        for (UserModel u : user.getFollowed())
            followed.add(UserMapper.userToFollowerDTO(u));

        if (order!=null){ //Check for param
            if (order.equals("name_asc")){ //Sort by name ascending
                List<UserDTO> sortedList =  followed.stream()
                        .sorted((o1, o2) -> { return o1.getUserName().compareTo(o2.getUserName()); })
                        .collect(Collectors.toList());

                followed= (ArrayList<UserDTO>) sortedList;
            }
            if (order.equals("name_desc")){ //Sort by name descending
                List<UserDTO> sortedList =  followed.stream()
                        .sorted((o1, o2) -> { return o2.getUserName().compareTo(o1.getUserName()); })
                        .collect(Collectors.toList());

                followed= (ArrayList<UserDTO>) sortedList;
            }

        }

        dto.setFollowed(followed);
        return dto;

    }

    @Override //US 0005: Create a new post - US 0010: Add promotion attributes
    public String US005(PostDTO newPost ) throws Exception{

        if (userRepositoryImple.getUsers().get(newPost.getUserId())==null) throw new NotFoundIdException(newPost.getUserId());

        List<PostModel> postlist = postRepositoryImple.getDbPosts();

        for (int i = 0; i <postlist.size() ; i++) {
            if (postlist.get(i).getId_post()==newPost.getId_post()) throw new PostIdExistsException();
        }

        postRepositoryImple.getDbPosts().add(PostMapper.dtoToModel(newPost));
        return "New post created";
    }

    @Override //US 0006: Last two weeks post of followed users sorted by date - US 0009: Sort by date ascending and descending
    public FollowedPostsDTO US006(int userId , String order) throws Exception{

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        FollowedPostsDTO followedPosts = new FollowedPostsDTO();
        followedPosts.setUserId(userId);
        //Load all Posts
        followedPosts.setPosts(postRepositoryImple.getDbPosts());
        //Load Users Followed
        List<UserModel> followed = userRepositoryImple.getUsers().get(userId).getFollowed();

        // Select posts by user ID
        List<PostModel> postlist = new ArrayList<>();
        for (int i = 0; i < followed.size(); i++) {
            for (int j = 0; j < followedPosts.getPosts().size(); j++) {
                if (followed.get(i).getUserId()==followedPosts.getPosts().get(j).getUserId()){
                    postlist.add(followedPosts.getPosts().get(j));
                }
            }
        }
        followedPosts.setPosts(postlist);

        // Delete old posts ( before two weeks ago)
        List<PostModel> auxList = new ArrayList<>();
        LocalDate dateOfTwoWeeks= LocalDate.now().minusWeeks(2);
        for (int i = 0; i < followedPosts.getPosts().size(); i++) {
            if (followedPosts.getPosts().get(i).getDate().isAfter(dateOfTwoWeeks)){
                auxList.add(followedPosts.getPosts().get(i));
            }
        }
        followedPosts.setPosts(auxList);

        // Sort posts by date ascending
        List<PostModel> sortedList = followedPosts.getPosts().stream()
                .sorted((o1, o2) -> { return o1.getDate().compareTo(o2.getDate()); })
                .collect(Collectors.toList());
        followedPosts.setPosts(sortedList);

        if (order!= null){ //check for param
            if (order.equals("date_asc")){ // Sort posts by date ascending
                followedPosts.setPosts(sortedList);
            }
            if (order.equals("date_desc")){ // Sort posts by date descending
                List<PostModel> descSorterList = new ArrayList<>();
                for (int i = 0; i < sortedList.size(); i++) {
                    descSorterList.add(sortedList.get(sortedList.size()-1-i));
                }
                followedPosts.setPosts(descSorterList);
            }
        }

        return followedPosts;
    }

    @Override //US 0007: Unfollow a user
    public String US007(int userId, int userIdToUnfollow) throws Exception{

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);
        if (userRepositoryImple.getUsers().get(userIdToUnfollow)==null) throw new NotFoundIdException(userIdToUnfollow);

        //Obtain followed and followers lists
        ArrayList <UserModel> followedList = userRepositoryImple.getUsers().get(userId).getFollowed();
        ArrayList <UserModel> followerList = userRepositoryImple.getUsers().get(userIdToUnfollow).getFollowers();

        //Delete user from followed list
        ArrayList <UserModel> auxList1 = new ArrayList<>();
        for (int i = 0; i < followedList.size(); i++) {
            if (followedList.get(i).getUserId()!=userIdToUnfollow){
                auxList1.add(followedList.get(i));
            }
        }

        if (auxList1.size()==followedList.size()) throw new IsNotaFollowerException(userId,userIdToUnfollow);

        //Delete user from followers list
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

    @Override //US 0011: Count posts with promo
    public CountPromoDTO US011(int userId) throws Exception{

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        CountPromoDTO countPromoDTO = new CountPromoDTO();
        countPromoDTO.setUserId(userId);
        countPromoDTO.setUserName(userRepositoryImple.getUsers().get(userId).getUserName());
        List<PostModel> post = postRepositoryImple.getDbPosts();
        int count = 0;
        for (int i = 0; i < post.size(); i++) {
            if ((post.get(i).getUserId()==userId)&&(post.get(i).isHasPromo())){
                count ++;
            }
        }
        countPromoDTO.setPromoProducts_count(count);
        return countPromoDTO;
    }

    @Override //US 0012: Post list with promotion
    public PostPromoDTO US012(int userId) throws Exception{

        if (userRepositoryImple.getUsers().get(userId)==null) throw new NotFoundIdException(userId);

        PostPromoDTO postPromoDTO = new PostPromoDTO();
        postPromoDTO.setUserId(userId);
        postPromoDTO.setUserName(userRepositoryImple.getUsers().get(userId).getUserName());
        ArrayList<PostModel> postDb = (ArrayList<PostModel>) postRepositoryImple.getDbPosts();

        //Select posts with promo
        ArrayList<PostNoUserIdDTO> postDto = new ArrayList<>();
        for (int i = 0; i < postDb.size(); i++) {
            if ((postDb.get(i).getUserId()==userId)&&(postDb.get(i).isHasPromo())){
                postDto.add(PostMapper.toNoIdDto(postDb.get(i)));
            }
        }
        postPromoDTO.setPosts(postDto);
        return postPromoDTO;
    }

}
