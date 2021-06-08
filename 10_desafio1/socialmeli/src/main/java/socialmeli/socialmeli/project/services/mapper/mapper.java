package socialmeli.socialmeli.project.services.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.services.Dto.FollowersListResponseDto;
import socialmeli.socialmeli.project.services.Dto.FollowersResponseDto;
import socialmeli.socialmeli.project.services.Dto.UserRequestDto;

import java.util.ArrayList;
import java.util.List;

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
}
