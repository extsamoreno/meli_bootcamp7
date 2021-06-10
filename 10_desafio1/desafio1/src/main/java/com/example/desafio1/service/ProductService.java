package com.example.desafio1.service;

import com.example.desafio1.dto.*;
import com.example.desafio1.exception.IDNotFoundException;
import com.example.desafio1.exception.IDPresentAllReadyException;
import com.example.desafio1.mapper.Mapper;
import com.example.desafio1.model.Post;
import com.example.desafio1.model.Product;
import com.example.desafio1.model.User;
import com.example.desafio1.repository.PostRepository;
import com.example.desafio1.repository.ProductRepository;
import com.example.desafio1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public ProductRepository productRepository;

	@Autowired
	public PostRepository postRepository;

	@Override
	public void newPost(NewPostDTO post) throws IDPresentAllReadyException {
		productRepository.registerProduct(Mapper.mapToProductModel(post.getDetail()));
		postRepository.registerNewPost(Mapper.mapToPostModel(post));
	}

	@Override
	public FollowedPostsDTO followedPosts(Integer userID) throws IDNotFoundException {
		List<User> followed = userRepository.getFollowed(userID);
		List<Post> posts = postRepository.getFollowedPosts(followed);

		posts = posts.stream().filter(p -> p.getDate().after(Date.from(LocalDateTime.now().minusWeeks(2).atZone(ZoneId.systemDefault()).toInstant())))
							  .collect(Collectors.toList());

		List<Product> products = productRepository.getProductsFromPosts(posts);

		return Mapper.mapToFollowedPostsDTO(userID, posts, products);
	}

	@Override
	public void newPromoPost(NewPromoDTO promo) throws IDPresentAllReadyException {
		productRepository.registerProduct(Mapper.mapToProductModel(promo.getDetail()));
		postRepository.registerNewPost(Mapper.mapToPostModel(promo));
	}

	@Override
	public PromoCountDTO promoCount(Integer userID) {
		User user = userRepository.getUser(userID);
		List<Post> posts = user.getPosts().stream().map(p -> postRepository.getPost(p))
												   .filter(Post::isHasPromo)
												   .collect(Collectors.toList());
		return Mapper.mapToPromoCountDTO(user, posts);
	}

	@Override
	public PromosDTO getPromos(Integer userID) {
		User user = userRepository.getUser(userID);
		List<Post> posts = user.getPosts().stream().map(p -> postRepository.getPost(p))
												   .filter(Post::isHasPromo)
												   .collect(Collectors.toList());

		List<Product> products = productRepository.getProductsFromPosts(posts);

		return Mapper.mapToPromosDTO(user, posts, products);
	}
}
