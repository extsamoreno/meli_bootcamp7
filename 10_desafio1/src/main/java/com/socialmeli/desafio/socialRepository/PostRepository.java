package com.socialmeli.desafio.socialRepository;

import com.socialmeli.desafio.model.PostModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PostRepository implements IPostRepository {

    private static HashMap<Integer, PostModel> publicationDataBase = new HashMap<>();



}
