package com.example.desafio1.controller;

import com.example.desafio1.dto.*;
import com.example.desafio1.exception.UserIDAllReadyInFollowsException;
import com.example.desafio1.exception.UserIDNotFoundException;
import com.example.desafio1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

	enum OrderEnum {
		NAME_ASC,
		NAME_DESC,
		DATE_ASC,
		DATE_DESC,
	}

	static Map<String, OrderEnum> OrderMap = Map.ofEntries(
			Map.entry("name_asc", OrderEnum.NAME_ASC),
			Map.entry("name_desc", OrderEnum.NAME_DESC),
			Map.entry("date_asc", OrderEnum.DATE_ASC),
			Map.entry("date_desc", OrderEnum.DATE_DESC)
	);

	@Autowired
	IUserService userService;

	// US0001
	@PostMapping("/{userID}/follow/{userIDToFollow}")
	ResponseEntity<HttpStatus> follow(@PathVariable Integer userID, @PathVariable Integer userIDToFollow) throws UserIDNotFoundException, UserIDAllReadyInFollowsException {

		return userService.follow(userID, userIDToFollow) ? new ResponseEntity<>(HttpStatus.OK)
														  : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	// US0002
	@GetMapping("/{userID}/followers/count")
	ResponseEntity<FollowerCountDTO> followersCount(@PathVariable Integer userID) throws UserIDNotFoundException {
		FollowerCountDTO count = userService.followerCount(userID);
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// US0003, US0008
	@GetMapping("/{userID}/followers/list")
	ResponseEntity<FollowersDTO> followersList(@PathVariable Integer userID, @RequestParam(required = false) String order) throws UserIDNotFoundException {

		FollowersDTO followers = userService.followersList(userID);

		if (order == null) {
			order = "name_asc";
		}

		switch (OrderMap.get(order)) {
			case NAME_ASC:
				followers.getFollowers().sort(Comparator.comparing(UserDTO::getUserName));
				break;
			case NAME_DESC:
				followers.getFollowers().sort(Comparator.comparing(UserDTO::getUserName).reversed());
				break;
			default:
				followers.getFollowers().sort(Comparator.comparing(UserDTO::getUserName));
				break;
		}

		return new ResponseEntity<>(followers, HttpStatus.OK);
	}

	// US0004, US0009
	@GetMapping("/{userID}/followed/list")
	ResponseEntity<FollowedDTO> followedList(@PathVariable Integer userID, @RequestParam(required = false) String order) throws UserIDNotFoundException {

		FollowedDTO followed = userService.followedList(userID);

		if (order == null) {
			order = "name_asc";
		}

		switch (OrderMap.get(order)) {
			case NAME_ASC:
				followed.getFollowed().sort(Comparator.comparing(UserDTO::getUserName));
				break;
			case NAME_DESC:
				followed.getFollowed().sort(Comparator.comparing(UserDTO::getUserName).reversed());
				break;
			default:
				followed.getFollowed().sort(Comparator.comparing(UserDTO::getUserName));
				break;
		}

		return new ResponseEntity<>(followed, HttpStatus.OK);
	}

	// US0007
	@PostMapping("/{userID}/unfollow/{userIDToUnfollow}")
	ResponseEntity<FollowDTO> unfollow(@PathVariable Integer userID, @PathVariable Integer userIDToUnfollow) {
		return new ResponseEntity<>(new FollowDTO(), HttpStatus.OK);
	}
}
