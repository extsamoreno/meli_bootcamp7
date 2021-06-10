package com.example.desafio1.service;

import com.example.desafio1.dto.*;
import com.example.desafio1.exception.IDPresentAllReadyException;
import com.example.desafio1.exception.IDNotFoundException;

public interface IProductService {
	void newPost(NewPostDTO post) throws IDPresentAllReadyException;

	FollowedPostsDTO followedPosts(Integer userID) throws IDNotFoundException;

	void newPromoPost(NewPromoDTO promo) throws IDPresentAllReadyException;

	PromoCountDTO promoCount(Integer userID);

	PromosDTO getPromos(Integer userID);
}
