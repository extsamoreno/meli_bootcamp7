package com.meli.demo.models;

import com.meli.demo.dtos.SellerResponseDTO;
import com.meli.demo.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data@NoArgsConstructor@AllArgsConstructor
public class ListSeller {
    private int userId;
    private String userName;
    private ArrayList<SellerResponseDTO> followed;
}
