package com.SocialMeli.controllers;


import com.SocialMeli.entities.User;
import com.SocialMeli.services.SocialMeliServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SocialMeli.mappers.*;
import com.SocialMeli.repositories.*;
import java.util.*;

@RestController
public class UsersControllers {

    @Autowired
    private SocialMeliServices sc;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName(); // Iniciar sesión
        return "{\"message\": \"Bienvenido a Social Meli, " + username + "!\"}";
    }

    @RequestMapping(value = "/following", method = RequestMethod.GET)
    public ArrayList<User> following(@RequestParam(value="name", defaultValue="unknown") String name) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (name.contains("unknown"))
            name = username;
        List ar = sc.following(name);
        ArrayList<User> foll = new ArrayList<User>(ar);
        return foll;
    }

    @RequestMapping(value = "/followers", method = RequestMethod.GET)
    public ArrayList<User> followers(@RequestParam(value="name", defaultValue="unknown") String name) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (name.contains("unknown"))
            name = username;
        List ar = sc.followers(name);
        ArrayList<User> foll = new ArrayList<User>(ar);
        return foll;
    }

    @RequestMapping(value = "/follow", method = { RequestMethod.PUT, RequestMethod.POST })
    public String follow(@RequestParam(value="name", required=true) String name) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (sc.follow(name, username) == 1)
            return "{\"status\": \"Success\", \"message\": \"Estas siguiendo al Vendedor\"} ";
        else if (sc.follow(name, username) == 2)
            return "{\"status\": \"Error\", \"message\": \"No puedes seguirte a ti mismo\"}";
        else if (sc.follow(name, username) == 0)
            return "{\"status\": \"Error\", \"message\": \"Ya sigues a este Vendedor :)\"}";
        else
            return "{\"status\": \"Error\", \"message\": \"None\"}";
    }

    @RequestMapping(value = "/unfollow", method = RequestMethod.PUT)
    public String unfollow(@RequestParam(value="name", required=true) String name) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (ts.unfollow(name, username) == 1)
            return "{\"status\": \"Success\", \"message\": \"Ya no estás siguiendo a este vendedor\"} ";
        else if (ts.follow(name, username) == 2)
            return "{\"status\": \"Error\", \"message\": \"No puedes seguirte a ti mismo\"}";
        else if (ts.follow(name, username) == 0)
            return "{\"status\": \"Error\", \"message\": \"Necesitas seguir a este usuario para dejar de seguirlo\"}";
        else
            return "{\"status\": \"Error\", \"message\": \"None\"}";
    }

    @RequestMapping(value="/feed", method = RequestMethod.GET)
    public ArrayList<Tweet> feed(@RequestParam(value="search", defaultValue="not_given") String search) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (search.contains("not_given"))
            search = "";
        List ar = sc.feed(username, search);
        ArrayList<Tweet> foll = new ArrayList<Tweet>(ar);
        return foll;

    }

}
