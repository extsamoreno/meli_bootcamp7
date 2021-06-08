package com.desafio1.meli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class User {
   private Integer id;
   private String name;
   private ArrayList<User> follow;
   private ArrayList<User> follower;
   private ArrayList<publication> publication;

   public User() {
      this.id = -1;
      this.name = "";
      this.follow = new ArrayList<>();
      this.follower = new ArrayList<>();
      this.publication = new ArrayList<>();
   }
}
