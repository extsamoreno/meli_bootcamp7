package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.service.dto.*;

public interface IPostService {
    void createPostByDTO(PostDTO postDTO) throws UserExceptionNotFound, UserExceptionWrongType, ProductExceptionNotFound, NumberNotGreaterThanZero, EmptyStringException, PostExceptionNotValid, ProductExceptionNotValid, PostExceptionNotExists, PostExceptionAlreadyExists;

    FollowedPostDTO getFollowedUsersPostsByUserId(int userId, String order) throws UserExceptionNotFound, UserExceptionWrongType, WrongOrderFieldException;

    void createPostPromoByDTO(PostPromoDTO post) throws PostExceptionNotValid, UserExceptionWrongType, PostExceptionNotExists, ProductExceptionNotValid, ProductExceptionNotFound, PostExceptionAlreadyExists, UserExceptionNotFound;

    PromoListDTO getPromoPostsByUserId(int userId) throws UserExceptionNotFound, UserExceptionWrongType;

    PromoCountDTO getPromoPostsCountByUserId(int userId) throws UserExceptionWrongType, UserExceptionNotFound;
}
