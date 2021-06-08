package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class FollowersDTO extends Following{
  private List <UserDTO> followers;

  public FollowersDTO(String userId, String userName, List <UserDTO> followers){
      super(userId,userName);
      this.setUserId(userId);
      this.setFollowers(followers);
  }
}
