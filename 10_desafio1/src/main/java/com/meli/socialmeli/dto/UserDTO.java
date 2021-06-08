package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDTO {

    private int userId;
    private String userName;
    private List<UserDTO> followers;
    private List<UserDTO> followed;
}
