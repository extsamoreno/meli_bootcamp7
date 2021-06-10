package com.meli.SocialMeli.models;

import com.meli.SocialMeli.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int idUser;
    private String userName;
    private boolean esVendedor = false;
    private List<UserDto> follower = new ArrayList<>();
    private List<UserDto> followed = new ArrayList<>();
}
