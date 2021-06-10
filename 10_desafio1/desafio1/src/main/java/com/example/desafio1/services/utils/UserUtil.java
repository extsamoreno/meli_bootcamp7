package com.example.desafio1.services.utils;

import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.models.MeliUser;

import java.util.List;

public class UserUtil {
    public static void sort(List<MeliUser> meliUserList, String order) throws OrderNotValidException {
        if (order == null)
            return;

        switch (order) {
            case "name_asc":
                meliUserList.sort((a, b) -> a.getUserName().compareTo(b.getUserName()));
                break;
            case "name_desc":
                meliUserList.sort((a, b) -> b.getUserName().compareTo(a.getUserName()));
                break;
            default:
                throw new OrderNotValidException(order);
        }
    }
}
