package meli.springchallenge.services;

import meli.springchallenge.dtos.PostDTO;
import meli.springchallenge.dtos.followedPostDTO;
import meli.springchallenge.models.Post;
import meli.springchallenge.repositories.IProductRepository;
import meli.springchallenge.services.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository productRepository;

    @Override
    public void createPost(PostDTO post) {
        productRepository.createProduct(PostMapper.productToModel(post.getDetail()));
        productRepository.createPost(PostMapper.postToModel(post));
    }

    @Override
    public followedPostDTO getFollowedPosts(int userId) {
        List<Post> posts;

        posts = productRepository.getPostByUserId(userId);
        return null;
    }


}
