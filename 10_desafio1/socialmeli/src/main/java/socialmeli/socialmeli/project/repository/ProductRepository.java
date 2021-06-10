package socialmeli.socialmeli.project.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.Post;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
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
                                        .filter(x -> x.getUserId() == userId)
                                        .collect(Collectors.toList());


        return getPreviousTwoWeeksPostsArr(arrayListPost);
    }

    // Previous two weeks condition
    private ArrayList<Post> getPreviousTwoWeeksPostsArr(ArrayList<Post> arrayListPost) {
        LocalDate todayLocalDate = LocalDate.now();
        LocalDate previousTwoWeeks = todayLocalDate.minusWeeks(2);
        ArrayList<Post> previousTwoWeeksPostsArr = new ArrayList<>();

        for(Post post : arrayListPost){

            LocalDate localDate = post.getDate()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate(); //Date to LocalDate
            if (localDate.isAfter(previousTwoWeeks) && localDate.isBefore(todayLocalDate)){
                previousTwoWeeksPostsArr.add(post);
            }
        }
        return previousTwoWeeksPostsArr;
    }

    @Override
    public ArrayList<Post> getArrayPromoPostById(Integer userId){
        ArrayList<Post> promoArr = (ArrayList<Post>) postArrayList
                .stream()
                .filter(x -> x.getUserId() == userId && x.isHasPromo()==true)
                .sorted()
                .collect(Collectors.toList());
        return promoArr;
    }

}
