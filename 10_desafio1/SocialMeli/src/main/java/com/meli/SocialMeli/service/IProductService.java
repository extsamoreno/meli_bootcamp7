package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.PostDto;
import com.meli.SocialMeli.dto.UserFollowedListDto;
import com.meli.SocialMeli.dto.UserFollowedpostDto;
import com.meli.SocialMeli.exception.InvalidPostException;
import com.meli.SocialMeli.exception.InvalidProductException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.model.Post;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

public interface IProductService {
    void newPost(PostDto postDto) throws ParseException, InvalidPostException, InvalidProductException;

    UserFollowedpostDto getFollowedPost(int userId, Optional<String> order) throws InvalidUserIdException;
}
