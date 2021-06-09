package bootcamp.desafio.spring.repository;

import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.model.id.PostId;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class PostRepository implements IPostRepository{

    private HashMap<Integer, Post> postDB;

    public PostRepository() {
        postDB = new HashMap<>();
        for (Post post: this.LoadDataBase()) {
            Integer id= new PostId(post.getUserId(), post.getIdPost()).hashCode();
            postDB.put(id, post);
        }
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

    private ArrayList<Post> LoadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile( "src/main/resources/static/posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<ArrayList<Post>> typeRef = new TypeReference<>() {};
        ArrayList<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
