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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

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
        postList=sortPostByDate(postList);
        postList=trimByDays(postList,14);
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

    public ArrayList<Post> sortPostByDate(ArrayList<Post> postList) {
        for (int i = 0; i < postList.size()-1; i++) {
            for (int j = 0; j < postList.size() - 1; j++) {
                if (comparePost(postList.get(j),postList.get(j+1))) {
                    Post tmp = postList.get(j);
                    postList.set(j,postList.get(j+1));
                    postList.set(j+1,tmp);
                }
            }
        }
        return postList;
    }

    private boolean comparePost(Post post, Post post1) {
        if (post.getDate().before(post1.getDate())){
            return true;
        }else{
            return false;
        }
    }

    private ArrayList<Post> trimByDays(ArrayList<Post> postList,int days){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date curDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        for (int i = 0; i < postList.size(); i++) {
            if(ChronoUnit.DAYS.between(postList.get(i).getDate().toInstant(),curDate.toInstant())>days){
                postList=new ArrayList<>(postList.subList(0,i));
            }
        }
        return postList;
    }
}
