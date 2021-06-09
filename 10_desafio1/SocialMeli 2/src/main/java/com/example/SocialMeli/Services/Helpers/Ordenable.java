package com.example.SocialMeli.Services.Helpers;

import com.example.SocialMeli.Services.DTOs.PostDTO;

import java.util.Comparator;
import java.util.List;

public abstract class Ordenable<T> {

    public void bubbleOrder(List<T> ts, Comparator<T> comparator){

        for (int i = 0; i < ts.size(); i++) {
            for(int j=0;j<ts.size()-1;j++)
            {
                if(comparator.compare(ts.get(j+1),ts.get(j)) < 0)
                {
                    T aux = ts.get(j);
                    ts.set(j, ts.get(j+1));
                    ts.set(j+1, aux);
                }
            }

        }

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
        String standarOrder = "id";
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
