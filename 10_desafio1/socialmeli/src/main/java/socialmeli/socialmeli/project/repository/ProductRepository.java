package socialmeli.socialmeli.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.models.Post;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Repository
public class ProductRepository implements IProductRepository {
    public static ArrayList<Post> postArrayList = new ArrayList<>();

    @Override
    public void save(Post post) throws PostAlreadyExistsException {
        if(alreadyExists(post))
            throw new PostAlreadyExistsException(post);
        postArrayList.add(post);
    }

    private boolean alreadyExists(Post post) {
      return postArrayList.stream().anyMatch(x -> x.getIdPost().equals(post.getIdPost()));
    }


}
