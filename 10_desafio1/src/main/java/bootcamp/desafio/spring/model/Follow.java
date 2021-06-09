package bootcamp.desafio.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Follow {

    //one to many a users
    private Long idUserFollowing;

    //one to many a sellers
    private Long idUserFollower;

}
