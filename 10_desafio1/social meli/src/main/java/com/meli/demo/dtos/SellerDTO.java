package com.meli.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {
    private int id;
    private String nombre;
    private ArrayList<PostDTO> publicacions;
   // private ArrayList<PostDiscountDTO> postDto;
    private ArrayList<UserDTO> usuarios;
    //private ArrayList<DateUserFollowDTO> dateFollow;
}
