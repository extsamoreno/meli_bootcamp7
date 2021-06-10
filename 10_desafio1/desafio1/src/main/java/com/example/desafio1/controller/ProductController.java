package com.example.desafio1.controller;

import com.example.desafio1.dto.*;
import com.example.desafio1.exception.IDNotFoundException;
import com.example.desafio1.exception.IDAllReadyPresentException;
import com.example.desafio1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

import static com.example.desafio1.controller.UserController.OrderMap;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IProductService productService;

	// US0005
	@PostMapping("/newpost")
	ResponseEntity<HttpStatus> newpost(@RequestBody NewPostDTO post) throws IDAllReadyPresentException {

		productService.newPost(post);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	// US0006
	@GetMapping("/followed/{userID}/list")
	ResponseEntity<FollowedPostsDTO> followedPosts(@PathVariable Integer userID, @RequestParam(required = false) String order) throws IDNotFoundException {

		FollowedPostsDTO posts = productService.followedPosts(userID);

		if (order == null) {
			order = "date_asc";
		}

		switch (OrderMap.get(order)) {
			case DATE_ASC:
				posts.getPosts().sort(Comparator.comparing(PostDTO::getDate));
				break;
			case DATE_DESC:
				posts.getPosts().sort(Comparator.comparing(PostDTO::getDate).reversed());
				break;
			default:
				posts.getPosts().sort(Comparator.comparing(PostDTO::getDate));
				break;
		}

		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	// US0010
	@PostMapping("/newpromopost")
	ResponseEntity<PromoDTO> newPromoPost(@RequestBody NewPromoDTO promo) throws IDAllReadyPresentException {

		productService.newPromoPost(promo);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	// US0011
	@GetMapping("/{userID}/countPromo")
	ResponseEntity<PromoCountDTO> promoCount(@PathVariable Integer userID) {

		PromoCountDTO count = productService.promoCount(userID);

		return new ResponseEntity<>(count, HttpStatus.OK);
	}

	// US0012
	@GetMapping("/{userID}/list")
	ResponseEntity<PromosDTO> promoList(@PathVariable Integer userID) {

		PromosDTO posts = productService.getPromos(userID);

		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
}
