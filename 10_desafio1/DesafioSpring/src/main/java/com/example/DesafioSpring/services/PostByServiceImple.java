package com.example.DesafioSpring.services;

import com.example.DesafioSpring.dto.PostDTO;
import com.example.DesafioSpring.exceptions.*;
import com.example.DesafioSpring.models.Post;
import com.example.DesafioSpring.models.Product;
import com.example.DesafioSpring.models.User;
import com.example.DesafioSpring.repositories.IUserRepository;
import com.example.DesafioSpring.services.mapper.PostMapper;
import com.example.DesafioSpring.services.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostByServiceImple extends OrderByService implements IPostService{

    @Autowired
    IUserRepository iUserRepository;


    private Boolean productTaken(int productId){
        try{
            iUserRepository.getProductByID(productId);
            return true;
        }
        catch (ProductNotFoundException e){
            return false;
        }
    }
    public void productSave(Product product) throws ProductTakenException {
        List<Product> products = iUserRepository.getProducts();

        if(!this.productTaken(product.getId())){
            products.add(product);
        }
        else{
            throw new ProductTakenException(product.getId());
        }

    }
    private Boolean postInUse(int postId){
        try{
            iUserRepository.getPostByID(postId);
            return true;
        }
        catch (PostNotFoundException e){
            return false;
        }
    }
    public void postSave(Post post) throws PostTakenException, UserNotFoundException {

        User user = iUserRepository.getUserByID(post.getUserId());

        List<Post> posts = iUserRepository.getPosts();
        if(!this.postInUse(post.getId())){
            user.getPosts().add(post.getId());
            posts.add(post);
        }
        else{
            throw new PostTakenException(post.getId());
        }

    }
    @Override
    public void newPost(PostDTO postDTO) throws ProductTakenException, PostTakenException, UserNotFoundException {


        Post post = PostMapper.toPost(postDTO);
        Product product = ProductMapper.toProduct(postDTO.getDetail());

        if(this.productTaken(product.getId())){
            throw new ProductTakenException(product.getId());
        }
        if(this.postInUse(post.getId())){
            throw new PostTakenException(post.getId());
        }

        this.postSave(post);
        this.productSave(product);


    }

    @Override
    public List<PostDTO> getFollowedPost(int userId) throws PostNotFoundException, UserNotFoundException, ProductNotFoundException {

        User user = iUserRepository.getUserByID(userId);

        List<PostDTO> output = new ArrayList<>();
        for (int i = 0; i < user.getFollowing().size(); i++) {

            User followed = iUserRepository.getUserByID(user.getFollowing().get(i));
            List<Post> posts = iUserRepository.getPostsByIds(followed.getPosts());
            for (int j = 0; j < posts.size(); j++) {

                Product product = iUserRepository.getProductByID(posts.get(j).getProductId());
                output.add( PostMapper.toDTO(posts.get(j),product));
            }

        }
        this.filterPostByDate(output, LocalDate.now().minusWeeks(2), LocalDate.now());
        this.orderPostDTOs(output, "desc");
        return output;
    }


    private void filterPostByDate(List<PostDTO> posts ,LocalDate from, LocalDate until){

        for (int i = 0; i < posts.size(); i++) {
            LocalDate postDate = LocalDate.parse(posts.get(i).getDate());
            Boolean biggerThanUntil = (postDate.isAfter(from) || postDate.isEqual(from));
            Boolean smallerThanFrom = (postDate.isBefore(until) || postDate.isEqual(until));

            if(!(biggerThanUntil && smallerThanFrom)){
                posts.remove(i);
            }

        }

    }
    private void orderPostDTOs(List<PostDTO> posts, String order){

        Boolean condition = (order.equals("asc")) ? true : false;
        for (int i = 0; i < posts.size(); i++) {
            for(int j=0;j<posts.size()-1;j++)
            {
                LocalDate postDate = LocalDate.parse(posts.get(j+1).getDate());
                LocalDate previousPostDate = LocalDate.parse(posts.get(j).getDate());

                if(previousPostDate.isAfter(postDate) == condition)
                {
                    PostDTO aux = new PostDTO(posts.get(j).getUserId(),posts.get(j).getPostId(),posts.get(j).getDate(),posts.get(j).getDetail(),posts.get(j).getCategory(),posts.get(j).getPrice());
                    posts.set(j, posts.get(j+1));
                    posts.set(j+1, aux);
                }
            }

        }

    }

}
