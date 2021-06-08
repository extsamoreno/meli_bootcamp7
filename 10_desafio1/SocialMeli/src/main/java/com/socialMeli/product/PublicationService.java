package com.socialMeli.product;

import com.socialMeli.product.exceptions.FailCreatePostException;
import com.socialMeli.product.models.Post;
import com.socialMeli.product.repository.iProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService implements iPublicationService {

    @Autowired
    iProductRepository repository;

    @Override
    public Void newPost (Post post) throws FailCreatePostException {
        repository.newPost(post);
        return null;
    }
}
