package com.meli.socialmeli.util;

import com.meli.socialmeli.model.dao.model.User;

import java.util.Comparator;

public class SortDescNameUserUtil implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o2.getUserName().compareTo(o1.getUserName());
    }
}
