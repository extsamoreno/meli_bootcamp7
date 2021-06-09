package com.springChallenge.api.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post implements Comparable<Post>{
    private int userId;
    private int idPost;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    @Override
    public int compareTo(Post p) {
        return this.getDate().compareTo(p.getDate());
    }
}
