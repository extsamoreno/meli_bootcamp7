package com.example.DesafioSpring.services;

public abstract class OrderByService {
    String getOrderType(String order){
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
}
