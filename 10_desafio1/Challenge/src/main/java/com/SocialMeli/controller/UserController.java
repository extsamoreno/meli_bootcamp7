package com.SocialMeli.controller;

import com.SocialMeli.dtos.FollowedUserDTO;
import com.SocialMeli.dtos.FollowersCountDTO;
import com.SocialMeli.dtos.F
import com.SocialMeli.dtos.UserDTO;
import com.SocialMeli.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.SocialMeli.exceptions.*;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
   IUserService iUserService;

   //-----Usuarios que siguen a un vendedor-----Check

    @PostMapping ("/{userid}/follow/{useridtofollow}")
    public ResponseEntity<Boolean>  followUser(@PathVariable Integer userid, @PathVariable Integer useridtofollow) throws UserIdNotFoundException, UsersCantFollowThemselvesException {
        iUserService.follow(userid, useridtofollow);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // -----Cuantos usuarios siguen a un vendedor-----

    @GetMapping("/{userid}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCountById(@PathVariable int userId)
            throws UserIdNotFoundException {
        return new ResponseEntity<FollowersCountDTO>(iUserService.getFollowersCountById(userId), HttpStatus.OK);
    }

    //-----Lista de seguidores------

    @GetMapping("/{id}/followers/list")
    public ResponseEntity<UserDTO> followers(@PathVariable Integer id, @RequestParam Optional<String>  order) throws UserIdNotFoundException {
        return new ResponseEntity<userid, useridtofollow>(iuserService.getFollowers(id, order), HttpStatus.OK);
    }

    @GetMapping("/{id}/following/count")
    public ResponseEntity<UserDTO> followingCount(@PathVariable Integer id) throws UserIdNotFoundException {
        return new ResponseEntity<>(iuserService.getFollowingCount(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/following/list")
    public ResponseEntity<UserDTO> following(@PathVariable Integer id, @RequestParam Optional<String> order) throws UserIdNotFoundException {
        return new ResponseEntity<>(iuserService.getFollowing(id, order), HttpStatus.OK);
    }
}

/*


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