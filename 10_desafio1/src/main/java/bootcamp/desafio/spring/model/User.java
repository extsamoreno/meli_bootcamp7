package bootcamp.desafio.spring.model;


import lombok.*;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class User {

    private Long userId;
    private String userName;
    private ArrayList<Post> posts;

    public User() {
        this.posts= new ArrayList<>();
    }
}
