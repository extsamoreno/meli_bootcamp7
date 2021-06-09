package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSellersResponseDTO {
    private int userId;
    private String userName;
    private ArrayList<SellerResponseDTO> followed;
}
