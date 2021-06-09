package socialmeli.socialmeli.project.services.Dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersResponseDto {
    private Integer userId;
    private String userName;
    private Integer followers_count;
}
