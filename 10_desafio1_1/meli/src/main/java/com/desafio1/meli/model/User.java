package com.desafio1.meli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class User {
   private Integer id;
   private String name;
   private ArrayList<Publication> publication;

   public User() {
      this.id = -1;
      this.name = "";
      this.publication = new ArrayList<>();
   }
}
