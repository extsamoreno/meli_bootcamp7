package bootcamp.desafio.spring.model;


import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {

    private Long userId;
    private String userName;
}
