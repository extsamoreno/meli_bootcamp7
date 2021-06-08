package com.socialMeli.product;

import com.socialMeli.product.exceptions.FailCreatePostException;
import com.socialMeli.product.models.Post;

public interface iPublicationService {

    Void newPost (Post post) throws FailCreatePostException;
}
