package com.meli.SocialMeli.service;

import com.meli.SocialMeli.dto.*;
import com.meli.SocialMeli.exception.InvalidPostException;
import com.meli.SocialMeli.exception.InvalidProductException;
import com.meli.SocialMeli.exception.InvalidUserIdException;
import com.meli.SocialMeli.mapper.ProductMapper;
import com.meli.SocialMeli.mapper.UserMapper;
import com.meli.SocialMeli.model.Post;
import com.meli.SocialMeli.model.Product;
import com.meli.SocialMeli.model.User;
import com.meli.SocialMeli.repository.IProductRepository;
import com.meli.SocialMeli.repository.IUserRepository;
import com.meli.SocialMeli.util.SortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void newPost(PostDto postDto) throws ParseException, InvalidPostException, InvalidProductException {
        Post post;
        if(postDto.isHasPromo()){
            post = ProductMapper.postDtoToPromoPost(postDto);
        }else{
            post = ProductMapper.postDtoToPost(postDto);
        }
        Product product = ProductMapper.productDtoToProduct(postDto.getDetail());
        validatePost(post);
        validateProduct(product);
        int productId=iProductRepository.newProduct(product);
        post.setProductId(productId);
        iProductRepository.newPost(post);
    }

    @Override
    public UserFollowedpostDto getFollowedPost(int userId, Optional<String> order) throws InvalidUserIdException {
        validateId(userId);
        ArrayList<Post> postList = new ArrayList<>();
        for(User user : iUserRepository.getFolloweds(userId)){
            postList.addAll(iProductRepository.getPostByUser(user.getUserId()));
        }
        if(order.isEmpty()) order=Optional.of("aa");
        postList=sortPost(postList,order.get());
        postList=trimByDays(postList,14);
        ArrayList<PostResDto> postDtoList = new ArrayList<>();
        for(Post post : postList){
            if(!post.isHasPromo()){
                postDtoList.add(ProductMapper.postToResDto(post,iProductRepository.getProductById(post.getProductId())));
            }else {
                postDtoList.add(ProductMapper.postToPromoResDto(post,iProductRepository.getProductById(post.getProductId())));
            }
        }
        return new UserFollowedpostDto(userId,postDtoList);
    }

    @Override
    public UserPostCountDto getUserPromoCount(int userId) {
        ArrayList<Post> postList=iProductRepository.getPromoPostByUser(userId);
        User user = iUserRepository.getUserById(userId);
        return UserMapper.userToUserPostListDto(user,postList.size());
    }

    @Override
    public UserPostDto getUserPromo(int userId) {
        ArrayList<Post> postList=iProductRepository.getPromoPostByUser(userId);
        ArrayList<PostResDto> promoList = new ArrayList<>();
        for (Post post : postList) {
            promoList.add(ProductMapper.postToPromoResDto(post,iProductRepository.getProductById(post.getProductId())));
        }
        User user = iUserRepository.getUserById(userId);
        return UserMapper.userToUserPostDto(user,promoList);
    }

    private void validatePost(Post post) throws InvalidPostException {
        if(post.getId_post()<=0 ||
        post.getDate()==null ||
        post.getCategory()<=0 ||
        post.getPrice()<=0){
            throw new InvalidPostException();
        }
    }

    private void validateProduct(Product product) throws InvalidProductException {
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

    private ArrayList<Post> trimByDays(ArrayList<Post> postList,int days){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date curDate = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

        for (int i = 0; i < postList.size(); i++) {
            if(ChronoUnit.DAYS.between(postList.get(i).getDate().toInstant(),curDate.toInstant())>days){
                postList.remove(i);
                i--;
            }
        }
        return postList;
    }

    private ArrayList<Post> sortPost(ArrayList<Post> postList, String order) {
        Comparator<Post> comp;
        switch(order){
            case "date_asc":
                comp = (a,b)->(int)ChronoUnit.DAYS.between(a.getDate().toInstant(),b.getDate().toInstant());
                break;
            case "date_desc":
                comp = (a,b)->(int)ChronoUnit.DAYS.between(b.getDate().toInstant(),a.getDate().toInstant());
                break;
            default:
                return postList;
        }
        postList=new SortUtil<Post>().sort(postList,comp);
        return postList;
    }
}
