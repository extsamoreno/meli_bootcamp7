package socialmeli.socialmeli.project.services.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUnfollowRequestDto {
    private Integer userId;
    private Integer userIdToUnfollow;
}
