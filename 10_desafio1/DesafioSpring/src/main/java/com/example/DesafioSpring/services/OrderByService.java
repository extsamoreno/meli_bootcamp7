package com.example.DesafioSpring.services;

import java.util.Comparator;
import java.util.List;

public abstract class OrderByService <T> {
//Se hace clase aparte generica para poder ordenar y usar los metodos tanto en el servicio POST como en el de USER

    public void bubbleSort(List<T> list, Comparator<T> compare){

        for (int i = 0; i < list.size(); i++) {
            for(int j=0;j<list.size()-1;j++)
            {
                if(compare.compare(list.get(j+1),list.get(j)) < 0)
                {
                    T a = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, a);
                }
            }
        }
    }

    public String orderBy(String order){ //ordena poor id
        String standardOrder = "id";
        if(order != null){
            String[] orderArray = order.split("_");
            String orderType = (orderArray.length == 2) ? orderArray[1] : standardOrder;

            return orderType;
        }
        else{
            return standardOrder;
        }

    }
    public String orderType(String order){  //ordenar por tipo
        String standardOrder = "desc";
        if(order != null){
            String[] orderArray = order.split("_");
            String orderType = (orderArray.length == 2) ? orderArray[1] : standardOrder;

            return orderType;
        }
        else{
            return standardOrder;
        }

    }

}
