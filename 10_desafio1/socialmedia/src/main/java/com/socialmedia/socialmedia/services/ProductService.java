package com.socialmedia.socialmedia.services;

import com.socialmedia.socialmedia.exceptions.*;
import com.socialmedia.socialmedia.mappers.PostMapper;
import com.socialmedia.socialmedia.mappers.ProductMapper;
import com.socialmedia.socialmedia.mappers.UserMapper;
import com.socialmedia.socialmedia.repositories.IFollowerRepository;
import com.socialmedia.socialmedia.repositories.IProductRepository;
import com.socialmedia.socialmedia.repositories.IUserRepository;
import com.socialmedia.socialmedia.repositories.entities.*;
import com.socialmedia.socialmedia.services.Helpers.SortPostHelper;
import com.socialmedia.socialmedia.services.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
        if (Objects.isNull(existUser)) throw new ObjectExistException(existUser.getId(), "User");
        var existProduct = productRepository.getById(product.getId());
        if (!Objects.isNull(existProduct)) throw new ObjectExistException(existProduct.getId(), "Product");

        int idProduct = productRepository.add(product);

        if (idProduct == 0) throw new ProductInsertException();

        post.setProductId(idProduct);

        int idPost = postRepository.add(post);

        if (idPost == 0) throw new PostInsertException();
    }

    @Override
    public void addNewProductPromoWithPost(PostPromoDTO postPromoDTO) throws ObjectExistException, ObjectNotFoundException, ProductInsertException, PostInsertException {
        Post post = PostMapper.postPromoDtoToPost(postPromoDTO);
        Product product = ProductMapper.productDtoToProduct(postPromoDTO.getDetail());

        var existPost = postRepository.getByPostId(post.getPostId());
        if (!Objects.isNull(existPost)) throw new ObjectExistException(existPost.getId(), "Post");
        var existUser = userRepository.getById(post.getUserId());
        if (Objects.isNull(existUser)) throw new ObjectExistException(existUser.getId(), "User");
        var existProduct = productRepository.getById(product.getId());
        if (!Objects.isNull(existProduct)) throw new ObjectExistException(existProduct.getId(), "Product");

        int idProduct = productRepository.add(product);

        if (idProduct == 0) throw new ProductInsertException();

        post.setProductId(idProduct);

        int idPost = postRepository.add(post);

        if (idPost == 0) throw new PostInsertException();
    }

    @Override
    public UserCountPromoDTO getCountPromosByUser(int userId) throws ObjectNotFoundException, UserDistinctTypeException {
        User userById = userRepository.getById(userId);

        if (userById.getUserType() != 1) throw new UserDistinctTypeException(userById.getId(), "Vendedor");

        UserCountPromoDTO userResult = UserMapper.UserToUserCountPromoDTO(userById);

        List<Post> postsWithPromo = postRepository.getByUser(userId)
                .stream()
                .filter(x -> x.isHasPromo())
                .collect(Collectors.toList());

        userResult.setPromoproducts_count(postsWithPromo.size());

        return userResult;
    }

    @Override
    public UserWithPromosDTO getPromosByUser(int userId) throws ObjectNotFoundException, UserDistinctTypeException {
        User userById = userRepository.getById(userId);

        if (userById.getUserType() != 1) throw new UserDistinctTypeException(userById.getId(), "Vendedor");

        UserWithPromosDTO userResult = UserMapper.UserToUserPromoDTO(userById);

        List<Post> postsWithPromo = postRepository.getByUser(userId)
                .stream()
                .filter(x -> x.isHasPromo())
                .collect(Collectors.toList());

        List<PostPromoDTO> postPromoDTOS = new ArrayList<>();

        for (Post post: postsWithPromo){
            Product product = productRepository.getById(post.getProductId());

            PostPromoDTO postResult = PostMapper.PostToPostPromoDTO(post);
            ProductDTO productResult = ProductMapper.productToProductDTO(product);

            postResult.setDetail(productResult);
            postPromoDTOS.add(postResult);
        }

        userResult.setPosts(postPromoDTOS);

        return userResult;
    }

    @Override
    public UserWithFollowedPostsDTO getFollowedPostsByUser(int userId, String order) throws ObjectNotFoundException {
        User userResult = userRepository.getById(userId);
        List<Follower> followedByUser = followerRepository.getFollowersByFollowerId(userId);

        var result = UserMapper.UserToUserWithFollowedPostsDTO(userResult);

        List<PostDTO> postDTOList = new ArrayList<>();

        for (Follower followed : followedByUser) {
            if (!followed.isFollow()) continue;

            var postsByFollowed = postRepository.getByUserForTwoWeeksId(followed.getUserId());

            for (Post postByFollowed: postsByFollowed) {
                Product productByPost = productRepository.getById(postByFollowed.getProductId());

                ProductDTO productResult = ProductMapper.productToProductDTO(productByPost);

                PostDTO postResult = PostMapper.postToPostDTO(postByFollowed);

                postResult.setDetail(productResult);

                postDTOList.add(postResult);
            }
        }

        if (order.equals("date_asc")) orderByDate(postDTOList, true);
        else if (order.equals("date_desc")) orderByDate(postDTOList, false);

        result.setPosts(postDTOList);

        return result;
    }

    private void orderByDate(List<PostDTO> postDTOList, boolean isAscendent) {
        Collections.sort(postDTOList, new SortPostHelper());
        if (isAscendent) Collections.reverse(postDTOList);
    }
}
