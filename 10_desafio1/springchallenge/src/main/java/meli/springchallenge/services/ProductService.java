package meli.springchallenge.services;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.FollowedPostDTO;
import meli.springchallenge.dtos.UserDTO;
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

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public void createPost(PostDTO post) {
        productRepository.createProduct(PostMapper.productToModel(post.getDetail()));
        productRepository.createPost(PostMapper.postToModel(post));
    }

    @Override
    public FollowedPostDTO getFollowedPosts(int userId, String order){
        List<User> followed = userRepository.getFollowed(userId);
        List<PostDTO> postDTOs = new ArrayList<>();
        Date limitDate = getDateBeforeTwoWeeks(new Date(), 14);

        for(User u:followed){
            List<Post> posts = new ArrayList<>();

            try{
                posts = productRepository.getPostByUserId(u.getUserId());
            }catch (Exception e){
                e.printStackTrace();
            }

            if( order.equals("date_desc")){
                posts.sort((p1, p2) -> p2.getDate().compareTo(p1.getDate()));
            }else if(order.equals("date_asc")) {
                posts.sort((p1, p2) -> p1.getDate().compareTo(p2.getDate()));
            }

            for(Post p: posts){
                if ( limitDate.compareTo(p.getDate())<= 0) {
                    Product product = productRepository.getProductById(p.getProductId());
                    postDTOs.add(PostMapper.postToDTO(p, product));
                }
            }

        }


        return new FollowedPostDTO(userId, postDTOs);
    }


    private Date getDateBeforeTwoWeeks(Date date, int daysBefore) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, daysBefore * -1); //2 weeks
        return calendar.getTime();
    }

}
