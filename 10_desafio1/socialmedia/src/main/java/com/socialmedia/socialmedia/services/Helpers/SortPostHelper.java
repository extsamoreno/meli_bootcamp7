package com.socialmedia.socialmedia.services.Helpers;

import com.socialmedia.socialmedia.services.dtos.PostDTO;

import java.util.Comparator;

public class SortPostHelper implements Comparator<PostDTO> {
    @Override
    public int compare(PostDTO a, PostDTO b) {
        return a.getDate().compareTo(b.getDate());
    }
}
