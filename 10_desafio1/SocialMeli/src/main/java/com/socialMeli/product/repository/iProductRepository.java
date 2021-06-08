package com.socialMeli.product.repository;

import com.socialMeli.product.exceptions.FailCreatePostException;
import com.socialMeli.product.models.Post;

public interface iProductRepository {

    void newPost (Post post) throws FailCreatePostException;
}
