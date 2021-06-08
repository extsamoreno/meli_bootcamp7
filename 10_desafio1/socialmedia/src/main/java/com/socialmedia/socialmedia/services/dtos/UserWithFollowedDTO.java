package com.socialmedia.socialmedia.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithFollowedDTO extends UserDTO {
    private List<UserDTO> followed;
}
