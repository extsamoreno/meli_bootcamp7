package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.model.id.PostId;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository{

    private HashMap<Integer, Post> postDB;

    public PostRepository() {
        postDB= new HashMap<>();
    }

    @Override
    public Optional<Post> findById(PostId postId) {
        if(postDB.get(postId.hashCode()) != null){
            return Optional.of(postDB.get(postId.hashCode()));
        }
        return Optional.empty();
    }

    @Override
    public Post save(Post post) {
        Integer id= new PostId(post.getUserId(), post.getIdPost()).hashCode();
        postDB.put(id, post);
        return post;
    }

    @Override
    public ArrayList<Post> findAll() {
        ArrayList<Post> result = new ArrayList<>();
        for (Map.Entry<Integer, Post> hash : postDB.entrySet()) {
            result.add(hash.getValue());
        }
        return result;
    }


}
