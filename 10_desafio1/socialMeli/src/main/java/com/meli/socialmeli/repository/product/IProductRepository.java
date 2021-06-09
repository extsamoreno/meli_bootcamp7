package com.meli.socialmeli.repository.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.exception.CanNotCreatePostException;

import java.util.List;

public interface IProductRepository {
    void save(Publication post) throws CanNotCreatePostException;

    List<Publication> findByUserId(Integer userId);
}
