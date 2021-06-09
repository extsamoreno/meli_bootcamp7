package com.meli.socialmeli.model.dto;

import lombok.*;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListDTO {
    private int userId;
    private String userName;
    private ArrayList<UserSimpleDTO> followed = new ArrayList<>();
}
