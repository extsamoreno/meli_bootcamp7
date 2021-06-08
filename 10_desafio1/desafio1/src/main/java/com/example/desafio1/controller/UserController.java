package com.example.desafio1.controller;

import com.example.desafio1.dto.FollowDTO;
import com.example.desafio1.dto.UserDTO;
import com.example.desafio1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;

	// US0001
	@PostMapping("/{userID}/follow/{userIDToFollow}")
	ResponseEntity<UserDTO> follow(@PathVariable Integer userID, @PathVariable Integer userIDToFollow) {
		return new ResponseEntity<>(new UserDTO() , HttpStatus.OK);
	}

	// US0002
	@GetMapping("/{userID}/followers/count")
	ResponseEntity<FollowDTO> followersCount(@PathVariable Integer userID) {
		return new ResponseEntity<>(new FollowDTO() , HttpStatus.OK);
	}

	// US0003
	@GetMapping("/{userID}/followers/list")
	ResponseEntity<List<UserDTO>> followersList(@PathVariable Integer userID, @RequestParam(required = false) String order) {
		return new ResponseEntity<>(new ArrayList<UserDTO>() , HttpStatus.OK);
	}

	// US0004
	@GetMapping("/{userID}/followed/list")
	ResponseEntity<List<UserDTO>> followedList(@PathVariable Integer userID, @RequestParam(required = false) String order) {
		return new ResponseEntity<>(new ArrayList<UserDTO>() , HttpStatus.OK);
	}

	// US0007
	@PostMapping("/{userID}/unfollow/{userIDToUnfollow}")
	ResponseEntity<FollowDTO> unfollow(@PathVariable Integer userID, @PathVariable Integer userIDToUnfollow) {
		return new ResponseEntity<>(new FollowDTO() , HttpStatus.OK);
	}

	// // US0008
	// @GetMapping("/{userID}/followers/list")
	// ResponseEntity<List<UserDTO>> followersList(@PathVariable Integer userID, @RequestParam String order) {
	// 	return new ResponseEntity<>(new ArrayList<UserDTO>() , HttpStatus.OK);
	// }

	// // US0009
	// @GetMapping("/{userID}/followed/list")
	// ResponseEntity<List<UserDTO>> followedList(@PathVariable Integer userID, @RequestParam String order) {
	// 	return new ResponseEntity<>(new ArrayList<UserDTO>() , HttpStatus.OK);
	// }
}
