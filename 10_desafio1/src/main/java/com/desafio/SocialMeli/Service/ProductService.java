package com.desafio.SocialMeli.Service;

import com.desafio.SocialMeli.Model.Post;
import com.desafio.SocialMeli.Model.Product;
import com.desafio.SocialMeli.Model.User;
import com.desafio.SocialMeli.DTO.Post.*;
import com.desafio.SocialMeli.DTO.Product.ProductDTO;
import com.desafio.SocialMeli.DTO.User.FollowedPostListDTO;
import com.desafio.SocialMeli.Exception.Post.PostExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductExistsException;
import com.desafio.SocialMeli.Exception.Product.ProductNotExistsException;
import com.desafio.SocialMeli.Exception.User.OrderNotFoundException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import com.desafio.SocialMeli.Mapper.PostMapper;
import com.desafio.SocialMeli.Mapper.ProductMapper;
import com.desafio.SocialMeli.Repository.Post.IPostRepository;
import com.desafio.SocialMeli.Repository.Product.IProductRepository;
import com.desafio.SocialMeli.Repository.User.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                    Post post1 = PostMapper.PostWithUserDTOtoPost(postDTO);
                    iPostRepository.savePost(post1);
                    return postDTO;
                } else throw new ProductNotExistsException(postDTO.getDetail().getProduct_id());
            } else throw new UserIdNotFoundException(postDTO.getUserId());
        } else throw new PostExistsException(postDTO.getId_post());
    }

    @Override
    public FollowedPostListDTO getFollowedPosts14Days (int userId, String order) throws OrderNotFoundException {
        FollowedPostListDTO followedPostListDTO = new FollowedPostListDTO();
        followedPostListDTO.setUserId(userId);
        List<User> followedList = iUserRepository.getUserById(userId).getFollowed();
        List<PostDTO> posts = new ArrayList<>();
        for (User user : followedList) {
            posts.addAll(PostMapper.toPostDTO(iPostRepository.getPostByUserId(user.getUserId(), 14)));
        }

        if (order == null) {
            followedPostListDTO.setPosts(posts);
        } else switch(order)
            {
                case "date_asc":
                    Collections.sort(posts);
                    followedPostListDTO.setPosts(posts);
                    break;
                case "date_desc":
                    Collections.sort(posts, Collections.reverseOrder());
                    followedPostListDTO.setPosts(posts);
                    break;
                default:
                    throw new OrderNotFoundException(order);
            }

        return followedPostListDTO;
    }

    @Override
    public PromoPostWithUserDTO newPromoPost(PromoPostWithUserDTO promoPostWithUserDTO) throws PostExistsException, UserIdNotFoundException, ProductNotExistsException {
        Post post = iPostRepository.getPostById(promoPostWithUserDTO.getId_post());
        User user = iUserRepository.getUserById(promoPostWithUserDTO.getUserId());
        Product product = iProductRepository.getProductById(promoPostWithUserDTO.getDetail().getProduct_id());
        Product productDTO = ProductMapper.toProduct(promoPostWithUserDTO.getDetail());

        boolean productExists = productDTO.equals(product);

        if (post == null) {
            if (user != null) {
                if (productExists) {
                    Post promoPost = PostMapper.PromoPostDTOtoPost(promoPostWithUserDTO);
                    iPostRepository.savePost(promoPost);
                    return promoPostWithUserDTO;
                } else throw new ProductNotExistsException(promoPostWithUserDTO.getDetail().getProduct_id());
            } else throw new UserIdNotFoundException(promoPostWithUserDTO.getUserId());
        } else throw new PostExistsException(promoPostWithUserDTO.getId_post());
    }

    @Override
    public PromoCountDTO getPromoPostCount(int userId) throws UserIdNotFoundException {
        PromoCountDTO promoCountDTO = new PromoCountDTO();
        User user = iUserRepository.getUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException(userId);
        } else {
            promoCountDTO.setUserId(user.getUserId());
            promoCountDTO.setUserName(user.getUserName());
            promoCountDTO.setPromoproducts_count(iPostRepository.getPromoPostsByUserId(userId).size());
        }
        return promoCountDTO;
    }

    @Override
    public ListPromoPostDTO getPromoPostListByUserId(int userId) throws UserIdNotFoundException {
        ListPromoPostDTO listPromoPostDTO = new ListPromoPostDTO();
        User user = iUserRepository.getUserById(userId);
        if (user == null) {
            throw new UserIdNotFoundException(userId);
        } else {
            listPromoPostDTO.setUserId(user.getUserId());
            listPromoPostDTO.setUserName(user.getUserName());
            listPromoPostDTO.setPosts(iPostRepository.getPromoPostsByUserId(user.getUserId()));
        }
        return listPromoPostDTO;
    }

}