package meli.springchallenge.services;

import meli.springchallenge.dtos.*;
import meli.springchallenge.exceptions.PostIdNotValidException;
import meli.springchallenge.exceptions.ProductIdNotValidException;
import meli.springchallenge.exceptions.UserNotValidException;
import meli.springchallenge.models.Post;
import meli.springchallenge.models.Product;
import meli.springchallenge.models.User;
import meli.springchallenge.repositories.IProductRepository;
import meli.springchallenge.repositories.IUserRepository;
import meli.springchallenge.services.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public void createPost(PostDTO post) throws ProductIdNotValidException, PostIdNotValidException, UserNotValidException {
        userRepository.validateUser(post.getUserId());
        productRepository.createProduct(PostMapper.productToModel(post.getDetail()));
        productRepository.createPost(PostMapper.postToModel(post));
    }

    @Override
    public FollowedPostDTO getFollowedPosts(int userId, String order, int daysBefore) throws UserNotValidException {

        userRepository.validateUser(userId);
        List<User> followed = userRepository.getFollowed(userId);
        List<PostDTO> postDTOs = new ArrayList<>();
        Date limitDate = getDateBeforeTwoWeeks(new Date(), daysBefore);

        for(User u:followed){
            List<Post> posts = new ArrayList<>();
            try{
                posts = productRepository.getPostsByUserId(u.getUserId());
            }catch (Exception e){
                e.printStackTrace();
            }
            for(Post p: posts)
                if (limitDate.compareTo(p.getDate()) <= 0) {
                    Product product = productRepository.getProductById(p.getProductId());
                    postDTOs.add(PostMapper.postToDTO(p, product));
                }
        }

        if( order.equals("date_desc")) {
            postDTOs.sort((p1, p2) -> p2.getDate().compareTo(p1.getDate()));
        }
        else if(order.equals("date_asc")) {
            postDTOs.sort((p1, p2) -> p1.getDate().compareTo(p2.getDate()));
        }

        return new FollowedPostDTO(userId, postDTOs);
    }

    @Override
    public CountPromoDTO countPromoPost(int userId) throws UserNotValidException {

        String userName = userRepository.getUserById(userId).getUserName();
        int countPost = 0;
        try{
            List<Post> posts = productRepository.getPostsByUserId(userId);
            for(Post p:posts) if (p.isHasPromo()) countPost++;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new CountPromoDTO( userId, userName, countPost);
    }

    @Override
    public PostsListDTO getPostsByUserId(int userId, String filter) throws UserNotValidException {
        String userName = userRepository.getUserById(userId).getUserName();
        List<Post> filteredPosts = new ArrayList<>();
        List<PostDTO> postDTOs = new ArrayList<>();
        try{
            List<Post>  posts = productRepository.getPostsByUserId(userId);
            if(filter.equals("hasPromo"))
                filteredPosts = posts.stream().filter(Post::isHasPromo).collect(Collectors.toList());
            else filteredPosts = posts;
        }catch (Exception e){
            e.printStackTrace();
        }
        for(Post p:filteredPosts){
            Product product = productRepository.getProductById(p.getProductId());
            postDTOs.add(PostMapper.postToDTO(p, product));
        }
        return new PostsListDTO( userId, userName, postDTOs);
    }

    @Override
    public String deletePost(int postId) throws PostIdNotValidException {
        Post post = productRepository.getPostById(postId);
        if (post == null){
            throw new PostIdNotValidException(postId);
        }
        productRepository.deleteProduct(post.getProductId());
        productRepository.deletePost(postId);

        return "Post #" + postId + "Successfully deleted";
    }

    private Date getDateBeforeTwoWeeks(Date date, int daysBefore) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, daysBefore * -1);
        return calendar.getTime();
    }

}
