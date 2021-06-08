package com.meli.socialmeli.repository.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    public static List<Publication> postList = new ArrayList<>();

    @Override
    public void save(Publication post) throws CanNotCreatePostException {
        if (alreadyExists(post)) throw new CanNotCreatePostException(post.getId_post());
        else this.create(post);
    }

    private void create(Publication post) {
        postList.add(post);
    }

    private boolean alreadyExists(Publication post) {
        return postList.stream().anyMatch(x -> x.getId_post().equals(post.getId_post()));
    }
}
