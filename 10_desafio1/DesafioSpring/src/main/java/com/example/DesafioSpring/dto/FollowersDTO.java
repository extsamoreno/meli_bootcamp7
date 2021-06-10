package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class FollowersDTO extends UserDTO{
  private List <UserDTO> followers;

  public FollowersDTO(int userId, String userName, List <UserDTO> followers){
      super(userId,userName);
      this.setUserId(userId);
      this.setFollowers(followers);
  }
}
