package com.example.SocialMeli.Services;

import com.example.SocialMeli.Exceptions.*;
import com.example.SocialMeli.Models.Post;
import com.example.SocialMeli.Models.Product;
import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Repositories.iDataRepository;
import com.example.SocialMeli.Services.DTOs.*;
import com.example.SocialMeli.Services.Helpers.Ordenable;
import com.example.SocialMeli.Services.Mapper.PostMapper;
import com.example.SocialMeli.Services.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService extends Ordenable<PostDTO> implements iPostService{

    @Autowired
    iDataRepository iDataRepository;

    @Override
    public PostCountDTO getPromPostsCant(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {

        User user = iDataRepository.getUserByID(userId);

        return new PostCountDTO(user.getId(), user.getName(), this.getPromPostsByUser(userId).size());

    }
    public List<PromoPostDTO> getPromPostsByUser(int userId) throws UserNotFoundException, ProductNotFoundException, PostNotFoundException {

        User user = iDataRepository.getUserByID(userId);
        List<PromoPostDTO> output = new ArrayList<>();
        List<Post> posts = iDataRepository.getPostsByIds(user.getPosts());
        for (int j = 0; j < posts.size(); j++) {
            if (posts.get(j).getHasPromo()){
                Product product = iDataRepository.getProductByID(posts.get(j).getProductId());
                output.add( PostMapper.toPromDTO(posts.get(j),product));
            }
        }

        return output;

    }
    private Boolean isPostIdUsed(int postId){
        try{
            iDataRepository.getPostByID(postId);
            return true;
        }
        catch (PostNotFoundException e){
            return false;
        }
    }
    private Boolean isProductIdUsed(int productId){
        try{
            iDataRepository.getProductByID(productId);
            return true;
        }
        catch (ProductNotFoundException e){
            return false;
        }
    }
    public void saveProduct(Product product) throws ProductIdInUseException {
        List<Product> products = iDataRepository.getProducts();

        if(!this.isProductIdUsed(product.getId())){
            products.add(product);
        }
        else{
            throw new ProductIdInUseException(product.getId());
        }

    }

    public void savePost(Post post) throws PostIdInUseException, UserNotFoundException {

        User user = iDataRepository.getUserByID(post.getUserId());

        List<Post> posts = iDataRepository.getPosts();
        if(!this.isPostIdUsed(post.getId())){
            user.getPosts().add(post.getId());
            posts.add(post);
        }
        else{
            throw new PostIdInUseException(post.getId());
        }

    }
    @Override
    public void makePost(NonPromoPostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {

        savePostInformation(PostMapper.toPost(postDTO), postDTO.getDetail());

    }

    private void savePostInformation(Post post, ProductDTO detail) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {

        Product product = ProductMapper.toProduct(detail);

        if(this.isProductIdUsed(product.getId())){
            throw new ProductIdInUseException(product.getId());
        }
        if(this.isPostIdUsed(post.getId())){
            throw new PostIdInUseException(post.getId());
        }
        this.savePost(post);
        this.saveProduct(product);
    }

    @Override
    public void makePost(PromoPostDTO postDTO) throws ProductIdInUseException, PostIdInUseException, UserNotFoundException {

        savePostInformation(PostMapper.toPost(postDTO), postDTO.getDetail());

    }
    @Override
    public List<PostDTO> getFollowedPost(int userId, String order) throws PostNotFoundException, UserNotFoundException, ProductNotFoundException {

        User user = iDataRepository.getUserByID(userId);
        List<PostDTO> output = new ArrayList<>();
        for (int i = 0; i < user.getFollowing().size(); i++) {
            User followed = iDataRepository.getUserByID(user.getFollowing().get(i));
            List<Post> posts = iDataRepository.getPostsByIds(followed.getPosts());
            for (int j = 0; j < posts.size(); j++) {
                if(!posts.get(j).getHasPromo()){
                    Product product = iDataRepository.getProductByID(posts.get(j).getProductId());
                    output.add( PostMapper.toDTO(posts.get(j),product));
                }
            }
        }
        Comparator<PostDTO> compatator = this.getComparator(order);
        this.filterPostByDate(output, LocalDate.now().minusWeeks(2), LocalDate.now());
        this.bubbleOrder(output, compatator);
        return output;
    }

    private Comparator<PostDTO> getComparator(String order){
        Comparator<PostDTO> comparator;
        String orderBy = this.getOrderBy(order);
        String orderType = this.getOrderType(order);
        switch (orderBy){
            case "date": comparator = Comparator.comparing(PostDTO::getDate);
            case "id": comparator = Comparator.comparing(PostDTO::getPostId);
            default: comparator = Comparator.comparing(PostDTO::getDate);;
        }
        switch (orderType){
            case "desc" : comparator = comparator.reversed();
        }
        return comparator;

    }
    private void filterPostByDate(List<PostDTO> posts ,LocalDate from, LocalDate until){

        for (int i = 0; i < posts.size(); i++) {
            LocalDate postDate = posts.get(i).getDate();
            Boolean biggerThanUntil = (postDate.isAfter(from) || postDate.isEqual(from));
            Boolean smallerThanFrom = (postDate.isBefore(until) || postDate.isEqual(until));

            if(!(biggerThanUntil && smallerThanFrom)){
                posts.remove(i);
            }

        }

    }




}
