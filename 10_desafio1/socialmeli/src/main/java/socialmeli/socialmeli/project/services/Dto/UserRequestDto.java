package socialmeli.socialmeli.project.services.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private Integer userId;
    private Integer userIdToFollow;
}
