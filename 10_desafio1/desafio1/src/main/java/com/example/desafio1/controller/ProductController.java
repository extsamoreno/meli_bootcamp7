package com.example.desafio1.controller;

import com.example.desafio1.dto.PostDTO;
import com.example.desafio1.dto.PromoCountDTO;
import com.example.desafio1.dto.PromoDTO;
import com.example.desafio1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	IProductService productService;

	// US0005
	@PostMapping("/newpost")
	ResponseEntity<HttpStatus> newpost(@RequestBody PostDTO post) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// US0006
	@GetMapping("/followed/{userID}/list")
	ResponseEntity<List<PostDTO>> followedPosts(@PathVariable Integer userID, @RequestParam(required = false) String order) {
		return new ResponseEntity<>(new ArrayList<PostDTO>(), HttpStatus.OK);
	}

	// US0010
	@PostMapping("/newpromopost")
	ResponseEntity<PromoDTO> newPromoPost(@RequestBody PromoDTO promo) {
		return new ResponseEntity<>(new PromoDTO(), HttpStatus.OK);
	}

	// US0011
	@GetMapping("/{userID}/countPromo")
	ResponseEntity<PromoCountDTO> promoCount(@PathVariable Integer userID) {
		return new ResponseEntity<>(new PromoCountDTO(), HttpStatus.OK);
	}

	// US0012
	@GetMapping("/{userID}/list")
	ResponseEntity<List<PromoDTO>> promoList(@PathVariable Integer userID) {
		return new ResponseEntity<>(new ArrayList<PromoDTO>(), HttpStatus.OK);
	}
}
