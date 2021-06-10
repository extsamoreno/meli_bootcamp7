package com.example.desafio1.service;

import com.example.desafio1.dto.*;
import com.example.desafio1.exception.IDAllReadyPresentException;
import com.example.desafio1.exception.IDNotFoundException;

public interface IProductService {
	void newPost(NewPostDTO post) throws IDAllReadyPresentException;

	FollowedPostsDTO followedPosts(Integer userID) throws IDNotFoundException;

	void newPromoPost(NewPromoDTO promo) throws IDAllReadyPresentException;

	PromoCountDTO promoCount(Integer userID);

	PromosDTO getPromos(Integer userID);
}
