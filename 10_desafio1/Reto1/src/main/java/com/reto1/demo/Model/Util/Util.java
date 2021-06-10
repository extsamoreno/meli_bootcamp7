package com.reto1.demo.Model.Util;


import com.reto1.demo.Model.DTO.PostObjects.PostDTO;
import com.reto1.demo.Model.Post;
import com.reto1.demo.Model.DTO.UserObjets.UserDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Util{

    public static void orderAscByUserName(ArrayList<UserDTO> users) {
        Comparator<UserDTO> c = (u1, u2) -> u1.getName().compareTo(u2.getName());
        users.sort(c);
    }

    public static void orderDescByUserName(ArrayList<UserDTO> users) {
        Comparator<UserDTO> c = (u1, u2) -> u2.getName().compareTo(u1.getName());
        users.sort(c);
    }

    public static void orderDescByDate(List<Post> posts){
        Comparator<Post> c = (p1, p2) -> p2.getDate().compareTo(p1.getDate());
        posts.sort(c);
    }
    public static void orderAscByDateDTO(List<PostDTO> posts){
        Comparator<PostDTO> c = (p1, p2) -> p1.getDate().compareTo(p2.getDate());
        posts.sort(c);
    }

    public static void orderDescByDateDTO(List<PostDTO> posts) {
        Comparator<PostDTO> c = (p1, p2) -> p2.getDate().compareTo(p1.getDate());
        posts.sort(c);
    }


    public static LocalDate toLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    public static Date toDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
