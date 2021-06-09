package socialmeli.socialmeli.project.services.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import socialmeli.socialmeli.project.models.User;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class FollowedListResponseDto {
    private Integer userId;
    private String userName;
    ArrayList<User> followed;
}


