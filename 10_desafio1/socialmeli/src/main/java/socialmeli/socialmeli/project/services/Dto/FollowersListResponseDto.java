package socialmeli.socialmeli.project.services.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import socialmeli.socialmeli.project.models.User;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class FollowersListResponseDto {
    private Integer userId;
    private String userName;
    ArrayList<User> followers;
}
