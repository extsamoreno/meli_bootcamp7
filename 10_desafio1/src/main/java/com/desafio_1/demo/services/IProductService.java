package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.ProductFollowedDTO;
import com.desafio_1.demo.dtos.ProductPromoCountDTO;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import com.desafio_1.demo.exceptions.*;

public interface IProductService {
    void addProduct(ProductRequestDTO product) throws UnhandledException, UserIdInvalidException, UserNotFoundException, ProductDateInvalidException, ProductDetailRequiredException, ProductCategoryInvalidException, ProductPriceInvalidException, ProductIdPostInvalidException, ProductDetailTypeRequiredException, ProductDetailNameRequiredException, ProductDetailBrandRequiredException, ProductDetailColorRequiredException, ProductDetailIdInvalidException, ProductDiscountInvalidException, ProductHasPromoNotTrueException;

    ProductFollowedDTO findProductsByFollowedId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    ProductPromoCountDTO findProductsPromoCountByUserId(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException;
}