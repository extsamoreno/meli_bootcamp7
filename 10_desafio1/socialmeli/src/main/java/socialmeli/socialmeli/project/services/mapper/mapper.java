package socialmeli.socialmeli.project.services.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowedListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserDto.FollowersResponseDto;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Component
public class mapper {

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
        return new Post(postDto.getUserId(),postDto.getIdPost(),postDto.getDate(),postDto.getDetail(),postDto.getCategory(),postDto.getPrice());
    }
}
