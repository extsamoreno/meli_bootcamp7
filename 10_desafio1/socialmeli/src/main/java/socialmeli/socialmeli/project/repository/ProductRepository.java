package socialmeli.socialmeli.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

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

    @Override
    public boolean alreadyExists(Post post) {
      return postArrayList.stream().anyMatch(x -> x.getIdPost().equals(post.getIdPost()));
    }

    @Override
    public ArrayList<Post> getArrayPostById(Integer userId) throws NoPostsFoundException {
        if(!postArrayList.stream().anyMatch(x -> x.getUserId() == userId))
            throw new NoPostsFoundException(userId);

        ArrayList<Post> arrayListPost = (ArrayList<Post>) postArrayList
                                        .stream()
                                        .filter(x -> x.getUserId() == userId).sorted()
                                        .collect(Collectors.toList());

        Collections.reverse(arrayListPost);
        return arrayListPost;
    }

}
