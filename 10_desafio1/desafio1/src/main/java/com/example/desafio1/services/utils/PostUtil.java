package com.example.desafio1.services.utils;

import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.models.Post;

import java.util.List;

public class PostUtil {
    public static void sort(List<Post> postList, String order) throws OrderNotValidException {
        if (order == null)
            return;

        switch (order) {
            case "date_asc":
                postList.sort((a, b) -> a.getDate().compareTo(b.getDate()));
                break;
            case "date_desc":
                postList.sort((a, b) -> b.getDate().compareTo(a.getDate()));
                break;
            default:
                throw new OrderNotValidException(order);
        }
    }
}
