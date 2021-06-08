package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.Classes.Post;
import com.desafio.SocialMeli.Classes.Product;
import com.desafio.SocialMeli.Classes.User;
import com.desafio.SocialMeli.DTO.FollowedPostListDTO;
import com.desafio.SocialMeli.DTO.PostWithUserDTO;
import com.desafio.SocialMeli.DTO.ProductDTO;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductNotExistsException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Mapper.PostMapper;
import com.desafio.SocialMeli.Mapper.ProductMapper;
import com.desafio.SocialMeli.Repository.Post.IPostRepository;
import com.desafio.SocialMeli.Repository.Product.IProductRepository;
import com.desafio.SocialMeli.Repository.User.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired IPostRepository iPostRepository;
    @Autowired IUserRepository iUserRepository;
    @Autowired IProductRepository iProductRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws ProductExistsException {
        if (iProductRepository.getAllProducts().stream().anyMatch(product -> product.getProduct_id() == productDTO.getProduct_id())) {
            throw new ProductExistsException(productDTO.getProduct_id());
        } else {
            iProductRepository.saveProduct(ProductMapper.toProduct(productDTO));
            return productDTO;
        }
    }

    @Override
    public PostWithUserDTO newPost(PostWithUserDTO postDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException {

        Post post = iPostRepository.getPostById(postDTO.getId_post());
        User user = iUserRepository.getUserById(postDTO.getUserId());
        Product product = iProductRepository.getProductById(postDTO.getDetail().getProduct_id());
        Product productDTO = ProductMapper.toProduct(postDTO.getDetail());

        boolean productExists = productDTO.equals(product);

        if (post == null) {
            if (user != null) {
                if (productExists) {
                    Post post1 = PostMapper.toPost(postDTO);
                    iPostRepository.savePost(post1);
                    return postDTO;
                } else throw new ProductNotExistsException(postDTO.getDetail().getProduct_id());
            } else throw new UserIdNotFoundException(postDTO.getUserId());
        } else throw new PostExistsException(postDTO.getId_post());
    }

    @Override
    public FollowedPostListDTO getFollowedPosts (int userId) {
        FollowedPostListDTO followedPostListDTO = new FollowedPostListDTO();
        followedPostListDTO.setUserId(userId);
        followedPostListDTO.setPosts(PostMapper.toPostDTO(iPostRepository.getPostByUserId(userId)));

        return followedPostListDTO;
    }

}