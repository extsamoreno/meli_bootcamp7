package socialmeli.socialmeli.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowAlreadyException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.FollowMyselfException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.UnfollowException;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IUserRepository;
import socialmeli.socialmeli.project.services.Dto.UserDto.*;
import socialmeli.socialmeli.project.services.mapper.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;

    //Follow user
    @Override
    public void followUser (UserRequestDto userRequestDto) throws IdNotFoundException, FollowMyselfException, FollowAlreadyException {
        if(userRequestDto.getUserId() == userRequestDto.getUserIdToFollow()){
            throw new FollowMyselfException(userRequestDto.getUserId().toString());
        }
        if (iUserRepository.getUserFollowersList(userRequestDto.getUserIdToFollow())
                .stream()
                .anyMatch(user -> user.getUserId() == userRequestDto.getUserId())) {
            throw new FollowAlreadyException(userRequestDto.getUserIdToFollow().toString());
        }
        else{
            addUserToFollowerList(userRequestDto);
            addUserToFollowedList(userRequestDto);
        }
    }

    private void addUserToFollowedList(UserRequestDto userRequestDto) throws IdNotFoundException {
        User userFollowed = iUserRepository.findUserById(userRequestDto.getUserIdToFollow());
        iUserRepository.getUserFollowedList(userRequestDto.getUserId())
                .add(new User(userFollowed.getUserId(),userFollowed.getUserName()));
    }

    private void addUserToFollowerList(UserRequestDto userRequestDto) throws IdNotFoundException {
        User userFollower = iUserRepository.findUserById(userRequestDto.getUserId());
        iUserRepository.getUserFollowersList(userRequestDto.getUserIdToFollow())
                .add(new User(userFollower.getUserId(),userFollower.getUserName()));
    }


    //Unfollow user
    @Override
    public void unfollowUser(UserUnfollowRequestDto userUnfollowRequestDto) throws IdNotFoundException, UnfollowException {
        if (!iUserRepository.getUserFollowersList(userUnfollowRequestDto.getUserIdToUnfollow())
                .stream()
                .anyMatch(user -> user.getUserId() == userUnfollowRequestDto.getUserId())) {
            throw new UnfollowException(userUnfollowRequestDto.getUserIdToUnfollow().toString());
        }
        removeUserFromFollowersList(userUnfollowRequestDto);
        removeUserFromFollowedList(userUnfollowRequestDto);
    }

    //Remove user from followed list
    private void removeUserFromFollowedList(UserUnfollowRequestDto userUnfollowRequestDto) throws IdNotFoundException {
        User userToRemove =  iUserRepository.getUserFollowedList(userUnfollowRequestDto.getUserId())
                .stream()
                .filter(x -> x.getUserId() == userUnfollowRequestDto.getUserIdToUnfollow())
                .findFirst()
                .get();

        iUserRepository.getUserFollowedList(userUnfollowRequestDto.getUserId())
                .remove(userToRemove);
    }

    //Remove user from followers list
    private void removeUserFromFollowersList(UserUnfollowRequestDto userUnfollowRequestDto) throws IdNotFoundException {
        User userToRemove = iUserRepository.getUserFollowersList(userUnfollowRequestDto.getUserIdToUnfollow())
                .stream()
                .filter(x -> x.getUserId() == userUnfollowRequestDto.getUserId())
                .findFirst()
                .get();

        iUserRepository.getUserFollowersList(userUnfollowRequestDto.getUserIdToUnfollow())
                .remove(userToRemove);
    }



    //Get followers count number by userId
    @Override
    public FollowersResponseDto getFollowersCountById (String userId) throws IdNotFoundException {
        User u = iUserRepository.findUserById(Integer.parseInt(userId));
        return mapper.toFollowersResponseDto(u,iUserRepository.getUserFollowersList(Integer.parseInt(userId)).size());
    }

    //Get followers list by userId
    @Override
    public FollowersListResponseDto getFollowersById(String userId, String order) throws IdNotFoundException {
        User user = iUserRepository.findUserById(Integer.parseInt(userId));
        ArrayList<User> userArr = new ArrayList<>();
        userArr.addAll(iUserRepository.getUserFollowersList(Integer.parseInt(userId)));


        Collections.sort(userArr, Comparator.comparing(User::getUserName)); //Sort asc
       if(order.equals("name_desc"))
           Collections.reverse(userArr); //Sort desc


        return mapper.toFollowersListResponseDto(user,userArr);
    }

    //Get followed list by userId
    @Override
    public FollowedListResponseDto getFollowedById(String userId, String order) throws IdNotFoundException {
        User user = iUserRepository.findUserById(Integer.parseInt(userId));

        ArrayList<User> userArr = new ArrayList<>();
        userArr.addAll(iUserRepository.getUserFollowedList(Integer.parseInt(userId)));

        Collections.sort(userArr, Comparator.comparing(User::getUserName)); //Sort asc
        if(order.equals("name_desc"))
            Collections.reverse(userArr); //Sort desc

        return mapper.toFollowedListResponseDto(user,userArr);
    }
}
