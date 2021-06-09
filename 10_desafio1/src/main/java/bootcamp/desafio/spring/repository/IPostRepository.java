package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.model.id.PostId;

import java.util.ArrayList;
import java.util.Optional;

public interface IPostRepository {


    public Optional<Post> findById(PostId postId);

    public Post save(Post post);

    ArrayList<Post> findAll();
}
