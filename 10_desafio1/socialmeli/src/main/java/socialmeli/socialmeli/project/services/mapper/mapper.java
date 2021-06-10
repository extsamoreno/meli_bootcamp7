package socialmeli.socialmeli.project.services.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IUserRepository;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowedListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersResponseDto;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@Component
public class mapper {
    @Autowired
    private static IUserRepository iUserRepository;


    public static FollowersResponseDto toFollowersResponseDto(User u, Integer i){
        return new FollowersResponseDto(u.getUserId(),u.getUserName(),i);
    }

    public static FollowersListResponseDto toFollowersListResponseDto(User u, ArrayList<User> arrayListFollowers) {
        ArrayList<User> listDto = new ArrayList<>();
        listDto.addAll(arrayListFollowers);
    return new FollowersListResponseDto(u.getUserId(),u.getUserName(),listDto);
    }

    public static FollowedListResponseDto toFollowedListResponseDto(User u, ArrayList<User> arrayListFollowers) {
        ArrayList<User> listDto = new ArrayList<>();
        listDto.addAll(arrayListFollowers);
        return new FollowedListResponseDto(u.getUserId(),u.getUserName(),listDto);
    }

    public static PostDto postToDto(Post post)
    {
        return new PostDto(post.getUserId(),post.getIdPost(),post.getDate(),post.getDetail(),post.getCategory(),post.getPrice());
    }

    public static Post dtoToPost(PostDto postDto)
    {
        return new Post(postDto.getUserId(),postDto.getIdPost(),postDto.getDate(),postDto.getDetail(),postDto.getCategory(),postDto.getPrice(), postDto.isHasPromo(), postDto.getDiscount());
    }

    public static PostArrayDto postArrayToDto (ArrayList<Post> arrayPost){
        PostArrayDto postArrayDto = new PostArrayDto();
        postArrayDto.getPostDtoList().addAll(arrayPost);
        return postArrayDto;
    }

   public static PostPromoDto postArrayPromoToDto(Integer userId, String userName,ArrayList<Post> arrayPost) throws IdNotFoundException {
       return new PostPromoDto(userId,userName,arrayPost.size());
    }
}
