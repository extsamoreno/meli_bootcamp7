package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.mappers.PostMapper;
import com.socialmedia.socialmedia.mappers.ProductMapper;
import com.socialmedia.socialmedia.mappers.UserMapper;
import com.socialmedia.socialmedia.repositories.IFollowerRepository;
import com.socialmedia.socialmedia.repositories.IProductRepository;
import com.socialmedia.socialmedia.repositories.IUserRepository;
import com.socialmedia.socialmedia.repositories.entities.*;
import com.socialmedia.socialmedia.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IFollowerRepository followerRepository;

    @Override
    public void addNewProductWithPost(PostDTO postDTO) throws ProductInsertException, PostInsertException, ObjectNotFoundException, ObjectExistException {
        Post post = PostMapper.postDtoToPost(postDTO);
        Product product = ProductMapper.productDtoToProduct(postDTO.getDetail());

        var existPost = postRepository.getByPostId(post.getPostId());
        if (!Objects.isNull(existPost)) throw new ObjectExistException(existPost.getId(), "Post");
        var existUser = userRepository.getById(post.getUserId());
        if (!Objects.isNull(existUser)) throw new ObjectExistException(existUser.getId(), "User");
        var existProduct = productRepository.getById(product.getId());
        if (!Objects.isNull(existProduct)) throw new ObjectExistException(existProduct.getId(), "Product");

        int idProduct = productRepository.add(product);

        if (idProduct == 0) throw new ProductInsertException();

        post.setPostId(idProduct);

        int idPost = postRepository.add(post);

        if (idPost == 0) throw new PostInsertException();
    }

    @Override
    public UserWithFollowedPostsDTO getFollowedPostsByUser(int userId) throws ObjectNotFoundException {
        User userResult = userRepository.getById(userId);
        List<Follower> followedByUser = followerRepository.getFollowersByFollowerId(userId);

        var result = UserMapper.UserToUserWithFollowedPostsDTO(userResult);

        List<PostDTO> postDTOList = new ArrayList<>();

        for (Follower followed : followedByUser) {
            var postsByFollowed = postRepository.getByUserForTwoWeeksId(followed.getUserId());

            for (Post postByFollowed: postsByFollowed) {
                Product productByPost = productRepository.getById(postByFollowed.getProductId());

                ProductDTO productResult = ProductMapper.productToProductDTO(productByPost);

                PostDTO postResult = PostMapper.postToPostDTO(postByFollowed);

                postResult.setDetail(productResult);

                postDTOList.add(postResult);
            }
        }

        orderByDate(postDTOList);

        result.setPosts(postDTOList);

        return result;
    }
    private void orderByDate(List<PostDTO> postDTOList) {
    }
}
