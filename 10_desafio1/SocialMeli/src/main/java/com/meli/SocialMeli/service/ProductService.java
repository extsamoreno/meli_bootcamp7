package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.PostDto;
import com.meli.SocialMeli.dto.PostResDto;
import com.meli.SocialMeli.dto.UserFollowedpostDto;
import com.meli.SocialMeli.exception.InvalidPostException;
import com.meli.SocialMeli.exception.InvalidProductException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.mapper.ProductMapper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.repository.IProductRepository;
import com.meli.SocialMeli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void newPost(PostDto postDto) throws ParseException, InvalidPostException, InvalidProductException {
        Post post = ProductMapper.postDtoToPost(postDto);
        Product product = ProductMapper.productDtoToProduct(postDto.getDetail());
        validatePost(post);
        validateProduct(product);
        int productId=iProductRepository.newProduct(product);
        post.setId(productId);
        iProductRepository.newPost(post);
    }

    @Override
    public UserFollowedpostDto getFollowedPost(int userId) throws InvalidUserIdException {
        validateId(userId);
        ArrayList<Post> postList = new ArrayList<>();
        for(User user : iUserRepository.getFolloweds(userId)){
            postList.addAll(iProductRepository.getPostByUser(user.getUserId()));
        }
        ArrayList<PostResDto> postDtoList = new ArrayList<>();
        for(Post post : postList){
            postDtoList.add(ProductMapper.postToResDto(post,iProductRepository.getProductById(post.getProductId())));
        }
        return new UserFollowedpostDto(userId,postDtoList);
    }

    public void validatePost(Post post) throws InvalidPostException {
        if(post.getId_post()<=0 ||
        post.getDate()==null ||
        post.getCategory()<=0 ||
        post.getPrice()<=0){
            throw new InvalidPostException();
        }
    }

    public void validateProduct(Product product) throws InvalidProductException {
        if(product.getProduct_id()<=0 ||
        product.getProductName()==null || product.getProductName().equals("") ||
        product.getBrand()==null || product.getBrand().equals("") ||
        product.getColor()==null || product.getColor().equals("") ||
        product.getType()==null || product.getType().equals("")){
            throw new InvalidProductException();
        }
    }

    private void validateId(int id) throws InvalidUserIdException {
        if(iUserRepository.getUserById(id)==null){
            throw new InvalidUserIdException();
        }
    }
}
