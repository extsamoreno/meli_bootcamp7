package com.example.SocialMeli.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private int userID;
    private String userName;

    public UserDTO(UserDTO userDTO){
        this.userID = userDTO.getUserID();
        this.userName = userDTO.getUserName();
    }

    public String getOrderType(String order){
        String standarOrder = "desc";
        if(order != null){
            String[] orderArray = order.split("_");
            String orderType = (orderArray.length == 2) ? orderArray[1] : standarOrder;

            return orderType;
        }
        else{
            return standarOrder;
        }

    }
    public String getOrderBy(String order){
        String standarOrder = "name";
        if(order != null){
            String[] orderArray = order.split("_");
            String orderType = (orderArray.length == 2) ? orderArray[1] : standarOrder;

            return orderType;
        }
        else{
            return standarOrder;
        }

    }
}
