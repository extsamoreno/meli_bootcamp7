package com.example.challenge.Services.DTOs;

import com.example.challenge.Models.Post;
import com.example.challenge.Models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDTO {
    private int id;
    private String name;
    private List<UserDTO> followed;
    private List<UserDTO> followers;
    private List<PostDTO> posts;

}
