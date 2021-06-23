package com.desafiospring.socialMeli.dto.response;

import com.desafiospring.socialMeli.dto.UserDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowingDTO {

    private int userId;
    private String userName;
    private List<UserDTO> followed;

}
