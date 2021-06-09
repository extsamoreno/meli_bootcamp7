package com.example.desafio1.mapper;

import com.example.desafio1.dto.*;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.Product;
import com.example.desafio1.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

	public static FollowerCountDTO mapToUserDTO(User user) {
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
		/* publishingList.stream()
				.filter(publishing -> publishing.getUserId() == userId)
				.filter(publishing -> publishing.getDate().isAfter(dateFrom) && publishing.getDate().isBefore(dateTo))
				.collect(Collectors.toList());*/
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

	public static Post mapToPostModel(PostDTO postDTO) {
		Post post = new Post();

		post.setPostID(postDTO.getPostID());
		post.setDate(postDTO.getDate());
		post.setDetail(postDTO.getDetail().getProductID());
		post.setCategory(postDTO.getCategory());
		post.setPrice(postDTO.getPrice());
		post.setHasPromo(false);
		post.setDiscount(0.0f);

		return post;
	}
}
