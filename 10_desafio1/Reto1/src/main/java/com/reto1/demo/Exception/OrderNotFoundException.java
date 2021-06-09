package com.reto1.demo.Exception;

import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends GeneralException {
    public OrderNotFoundException(String order, String name) {
        super("Order not found "+order+".Try use "
                +name+"_asc or "+name+"_desc", HttpStatus.CONFLICT);
    }
}
