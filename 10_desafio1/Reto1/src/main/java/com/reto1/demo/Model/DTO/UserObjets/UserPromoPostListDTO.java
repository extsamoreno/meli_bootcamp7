package com.reto1.demo.Model.DTO.UserObjets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPromoPostListDTO {
    int id;
    String name;
    List  posts;
}
