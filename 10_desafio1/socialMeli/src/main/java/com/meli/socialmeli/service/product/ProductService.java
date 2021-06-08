package com.meli.socialmeli.service.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.repository.product.IProductRepository;
import com.meli.socialmeli.service.SocialMeliMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public void createPost(PublicationDTO post) throws CanNotCreatePostException, InvalidDateFormatException {
        productRepository.save(SocialMeliMapper.toPublication(post));
    }
}
