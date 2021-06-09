package com.example.demo.Services.DTO;


import com.example.demo.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListFollowersDTO {

    private int userId;
    private String username;
    private List<UserDTO> followers;

}
