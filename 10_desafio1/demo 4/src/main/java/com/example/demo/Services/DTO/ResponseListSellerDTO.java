package com.example.demo.Services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListSellerDTO {

    private int userId;
    private String username;
    private List<UserDTO> followers;

}
