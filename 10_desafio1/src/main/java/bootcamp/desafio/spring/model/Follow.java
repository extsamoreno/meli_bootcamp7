package bootcamp.desafio.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Follow {

    private Long idUserFollow;
    private Long idUserFollower;
}
