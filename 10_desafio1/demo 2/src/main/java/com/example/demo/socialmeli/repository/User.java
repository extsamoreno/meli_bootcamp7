package com.example.demo.socialmeli.repository;

import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
@Data

public class User {
    private int userId;
    private String userName;
    private ArrayList<Integer> followed;
}
