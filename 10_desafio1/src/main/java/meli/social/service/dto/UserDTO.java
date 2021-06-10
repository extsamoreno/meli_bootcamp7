package meli.social.service.dto;

import lombok.*;

import java.util.Comparator;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter

public class UserDTO implements Comparator<UserDTO> {
    private int userId;
    private String userName;


    @Override
    public int compare(UserDTO o1, UserDTO o2) {
        return 0;
    }
}
