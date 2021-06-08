package bootcamp.desafio.spring.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCountFollowersDTO {

    private Long userId;
    private String userName;
    private int followers_count;

}
