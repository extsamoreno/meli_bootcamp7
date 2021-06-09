package com.spring.desafioSpring.DTOs;

import lombok.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer userId;
    private String userName;
    private List<UserIdNameDTO> followers;
    private List<UserIdNameDTO> followed;
}
