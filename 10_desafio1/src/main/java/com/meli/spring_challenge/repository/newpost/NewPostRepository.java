package com.meli.spring_challenge.repository.newpost;

import com.meli.spring_challenge.model.Post;

public interface NewPostRepository {
    void create(Post post);
}
