package com.example.demo.services;

import com.example.demo.model.DTO.UserDTO;
import com.example.demo.model.DTO.UserPostsDTO;
import com.example.demo.model.Post;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class ProductService implements IProductService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    Mapper mapper;

    @Override
    public Post newPost(int userId, int idPost, Date date, int productId, String productName, String type, String brand, String color, String notes, int category, double price) {
        User user = userRepository.getUserById(userId);
        Product product = new Product(productId, productName, type, brand, color, notes);
        Post post = new Post(userId, idPost, date, product, category, price);
        user.getPosts().add(post);
        return post;
    }

    @Override
    public UserPostsDTO getPostsFromFollowed(int userId) {
        User user = userRepository.getUserById(userId);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Post> posts = new ArrayList<>();
        UserPostsDTO userPostsDTO = mapper.toUserPostsDTO(userId, posts);

        for (UserDTO u: user.getFollowed()) {
            users.add(userRepository.getUserById(u.getId()));
        }

        for (User u : users) {
            for (Post p : u.getPosts()) {
                if(p.getDate().before(getDateBeforeTwoWeeks())){
                    posts.add(p);
                }
            }
        }

        return userPostsDTO;
    }

    private Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }
}
