package com.meli.socialmeli.repository.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.exception.CanNotCreatePostException;

public interface IProductRepository {
    void save(Publication post) throws CanNotCreatePostException;
}
