package com.desafio.SocialMeli.Exception.User;

import com.desafio.SocialMeli.Exception.SocialMeliException;
import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends SocialMeliException {
    public OrderNotFoundException(String order) {
        super("Order " + order + " not found. Possible orders: name_asc, name_desc", HttpStatus.BAD_REQUEST);
    }
}
