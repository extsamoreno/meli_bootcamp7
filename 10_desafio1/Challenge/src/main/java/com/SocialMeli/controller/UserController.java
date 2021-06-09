package com.SocialMeli.controller;

import com.SocialMeli.services.IUserService;
import com.SocialMeli.dtos.FollowedUserDTO;
import com.SocialMeli.dtos.FollowUserDTO;
import com.SocialMeli.dtos.CountFollowerUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("users")

public class UserController {

   @Autowired
   IUserService iUserService;

    @PostMapping("/{userID}/follow/{userIdToFollow}")
    public ResponseEntity<FollowUserDTO>unfollow (@PathVariable int followerId, @PathVariable int followedId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.unfollow(followerId, followedId), HttpStatus.OK);
    }

      @GetMapping("/users/{userId}/followers/count")
    public ResponseEntity<CountFollowerUserDTO> getFollowersCount (@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers (@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowers(userId), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed (@PathVariable int userId) throws UserNotFoundException {

        return new ResponseEntity<>(iUserService.getFollowed(userId), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> follow (){

        return new ResponseEntity<>(iUserService.getdb(), HttpStatus.OK);
    }

}

/*

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
        return foll; */