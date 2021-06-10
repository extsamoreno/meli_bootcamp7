package com.example.desafio1.mapper;

import com.example.desafio1.dto.*;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.Product;
import com.example.desafio1.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

	public static FollowerCountDTO mapToFollowerCountDTO(User user) {

		FollowerCountDTO count = new FollowerCountDTO();

		count.setUserID(user.getUserID());
		count.setUserName(user.getUserName());
		count.setFollowersCount(user.getFollows().size());

		return count;
	}

	public static FollowersDTO mapToFollowersDTO(User user, List<User> users) {

		FollowersDTO followers = new FollowersDTO();

		followers.setUserID(user.getUserID());
		followers.setUserName(user.getUserName());
		followers.setFollowers(users.stream().map(u -> new UserDTO(u.getUserID(), u.getUserName()))
											 .collect(Collectors.toList()));

		return followers;
	}

	public static FollowedDTO mapToFollowedDTO(User user, List<User> users) {

		FollowedDTO followed = new FollowedDTO();

		followed.setUserID(user.getUserID());
		followed.setUserName(user.getUserName());
		followed.setFollowed(users.stream().map(u -> new UserDTO(u.getUserID(), u.getUserName()))
										   .collect(Collectors.toList()));

		return followed;
	}

	public static Product mapToProductModel(ProductDTO detail) {

		Product product = new Product();

		product.setProductID(detail.getProductID());
		product.setProductName(detail.getProductName());
		product.setType(detail.getType());
		product.setBrand(detail.getBrand());
		product.setColor(detail.getColor());
		product.setNotes(detail.getNotes());

		return product;
	}

	public static Post mapToPostModel(NewPostDTO newPostDTO) {

		Post post = new Post();

		post.setPostID(newPostDTO.getPostID());
		post.setDate(newPostDTO.getDate());
		post.setDetail(newPostDTO.getDetail().getProductID());
		post.setCategory(newPostDTO.getCategory());
		post.setPrice(newPostDTO.getPrice());
		post.setHasPromo(false);
		post.setDiscount(0.0f);

		return post;
	}

	public static FollowedPostsDTO mapToFollowedPostsDTO(Integer userID, List<Post> posts, List<Product> products) {

		FollowedPostsDTO postsDTO = new FollowedPostsDTO();

		postsDTO.setUserID(userID);
		postsDTO.setPosts(posts.stream().map(p -> new PostDTO(p.getPostID(),
															  p.getDate(),
															  Mapper.mapToProductDTO(p.getDetail(), products),
															  p.getCategory(),
															  p.getPrice()))
										.collect(Collectors.toList()));

		return postsDTO;
	}

	public static ProductDTO mapToProductDTO(int detail, List<Product> products) {

		Product product = products.stream().filter(p -> p.getProductID() == detail)
										   .findAny()
										   .orElse(null);
		assert product != null;

		ProductDTO productDTO = new ProductDTO();

		productDTO.setProductID(product.getProductID());
		productDTO.setProductName(product.getProductName());
		productDTO.setType(product.getType());
		productDTO.setBrand(product.getBrand());
		productDTO.setColor(product.getColor());
		productDTO.setNotes(product.getNotes());

		return productDTO;
	}

	public static Post mapToPostModel(NewPromoDTO newPromoDTO) {

		Post post = new Post();

		post.setPostID(newPromoDTO.getPostID());
		post.setDate(newPromoDTO.getDate());
		post.setDetail(newPromoDTO.getDetail().getProductID());
		post.setCategory(newPromoDTO.getCategory());
		post.setPrice(newPromoDTO.getPrice());
		post.setHasPromo(newPromoDTO.isHasPromo());
		post.setDiscount(newPromoDTO.getDiscount());

		return post;
	}

	public static PromoCountDTO mapToPromoCountDTO(User user, List<Post> posts) {

		PromoCountDTO promoCountDTO = new PromoCountDTO();

		promoCountDTO.setUserID(user.getUserID());
		promoCountDTO.setUserName(user.getUserName());
		promoCountDTO.setPromoProductsCount(posts.size());

		return promoCountDTO;
	}

	public static PromosDTO mapToPromosDTO(User user, List<Post> posts, List<Product> products) {

		PromosDTO promosDTO = new PromosDTO();

		promosDTO.setUserID(user.getUserID());
		promosDTO.setUserName(user.getUserName());
		promosDTO.setPosts(posts.stream().map(p -> new PromoDTO(p.getPostID(),
																p.getDate(),
																Mapper.mapToProductDTO(p.getDetail(), products),
																p.getCategory(),
																p.getPrice(),
																p.isHasPromo(),
																p.getDiscount()))
										 .collect(Collectors.toList()));

		return promosDTO;
	}
}
