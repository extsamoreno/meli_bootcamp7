package com.desafio.socialMeli.service.dto;

import com.desafio.socialMeli.repository.entities.Product;
import com.desafio.socialMeli.repository.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    public static int FOLLOWERLIST = 1;
    public static int FOLLOWEDLIST = 2;
    private String name;
    private ArrayList<User> followerList;
    private ArrayList<User> followedList;

    public UserDTO() { //Integer userId, Integer id_post, String date, Product detail, String category, double price, boolean b, float discount
        this.name = "";
        this.followerList = new ArrayList<User>();
        this.followedList = new ArrayList<User>();
    }

    public boolean removeFollower(User user){
        boolean res = true;
        if(!isUserInList(user,FOLLOWERLIST)) res = false;
        else followerList.removeIf(eachElement -> eachElement.getName().equals(user.getName()));
        return res;
    }

    public boolean removeFollowed(User userToUnfollow){
        boolean res = true;
        if(!isUserInList(userToUnfollow,FOLLOWEDLIST)) res = false;
        else followedList.removeIf(eachElement -> eachElement.getName().equals(userToUnfollow.getName()));
        return res;
    }

    // Por ahora me puedo seguir a mi mismo
    public void addFollower(User user) {
        if(isUserInList(user, FOLLOWERLIST)) return;
        this.followerList.add(user);
    }

    public void addFollowed(User userToFollow) {
        if(isUserInList(userToFollow, FOLLOWEDLIST)) return;
        this.followedList.add(userToFollow);
    }


    public boolean isUserInList(User user, int listType){
        boolean res = false;
        for(User u: listType == FOLLOWERLIST ? this.followerList : this.followedList) if(u.getName().equals(user.getName())) res = true;
        return res;
    }
}
