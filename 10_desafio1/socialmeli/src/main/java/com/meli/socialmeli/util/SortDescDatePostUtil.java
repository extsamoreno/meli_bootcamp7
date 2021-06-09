package com.meli.socialmeli.util;

import com.meli.socialmeli.model.dao.model.Post;

import java.util.Comparator;

public class SortDescDatePostUtil implements Comparator<Post> {

        @Override
        public int compare(Post o1, Post o2) {
            return o2.getDate().compareTo(o1.getDate());
        }

}
