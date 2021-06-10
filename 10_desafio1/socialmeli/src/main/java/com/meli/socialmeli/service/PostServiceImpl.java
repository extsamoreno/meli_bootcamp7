package com.meli.socialmeli.service;

import com.meli.socialmeli.exception.PostAlreadyExists;
import com.meli.socialmeli.exception.PostDateBeforeToday;
import com.meli.socialmeli.exception.PostNotExistsException;
import com.meli.socialmeli.exception.UserNotExistsException;
import com.meli.socialmeli.model.Post;
import com.meli.socialmeli.model.User;
import com.meli.socialmeli.repository.IPostRepository;
import com.meli.socialmeli.repository.IUserRepository;
import com.meli.socialmeli.service.dto.PostDTO;
import com.meli.socialmeli.service.dto.PostFollowingDTO;
import com.meli.socialmeli.service.dto.ProductsUserDTO;
import com.meli.socialmeli.service.mapper.PostMapper;
import com.meli.socialmeli.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final Comparator<PostDTO> comparatorDateDesc = Comparator.comparing(PostDTO::getDate);
    private final Comparator<PostDTO> comparatorDateAsc = (a, b) -> b.getDate().compareTo(a.getDate());

    @Override
    public void addPost(PostDTO post) throws PostDateBeforeToday, PostAlreadyExists, UserNotExistsException {
        userService.userExists(post.getUserId());
        if (post.getPostId() != null && !existsPost(post.getPostId())) throw new PostAlreadyExists(post.getPostId());
        if (post.getDate() != null && DateUtil.dateBeforeDate(LocalDate.parse(post.getDate(), formatter), LocalDate.now()))
            throw new PostDateBeforeToday();
        postRepository.addPost(PostMapper.DTOToModel(post));
    }

    @Override
    public void updatePost(PostDTO post) throws PostNotExistsException, PostDateBeforeToday {
        if (!existsPost(post.getPostId())) throw new PostNotExistsException(post.getPostId());
        if (post.getDate() != null && DateUtil.dateBeforeDate(LocalDate.parse(post.getDate(), formatter), LocalDate.now()))
            throw new PostDateBeforeToday();
        postRepository.updatePost(PostMapper.DTOToModel(post));

    }

    @Override
    public void addPromoPost(PostDTO post) throws PostDateBeforeToday, PostNotExistsException, PostAlreadyExists, UserNotExistsException {
        if (post.getPostId() != null && existsPost(post.getPostId())) {
            updatePost(post);
        } else {
            addPost(post);
        }
    }

    @Override
    public List<PostDTO> getListPostByUserId(int userId) {
        List<Post> postList = postRepository.getListPostByUserId(userId);
        return postList.stream().map(PostMapper::modelToDTO).collect(Collectors.toList());
    }


    @Override
    public PostFollowingDTO getListPostUsersFollowingByUserId(int userId, String order) throws UserNotExistsException {
        userService.userExists(userId);
        List<Integer> followings = userRepository.getFollowingByUserId(userId);
        List<PostDTO> postsListFollowingUsers = new ArrayList<>();
        followings.forEach(followingId -> postsListFollowingUsers.addAll(getListPostByUserId(followingId)
                .stream()
                .filter(followingPost -> LocalDate.parse(followingPost.getDate(), formatter).isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList())
        ));
        sortListByOrder(postsListFollowingUsers, order);
        return new PostFollowingDTO(userId, postsListFollowingUsers);
    }

    @Override
    public PostFollowingDTO getListPromoPostUsersFollowingByUserId(int userId, String order) throws UserNotExistsException {
        userService.userExists(userId);
        List<Integer> followings = userRepository.getFollowingByUserId(userId);
        List<PostDTO> postsListFollowingUsers = new ArrayList<>();
        followings.forEach(e -> postsListFollowingUsers.addAll(getListPromoPostByUserId(e)
                .stream()
                .filter(followingPost -> LocalDate.parse(followingPost.getDate(), formatter).isAfter(LocalDate.now().minusWeeks(2)))
                .collect(Collectors.toList())
        ));
        sortListByOrder(postsListFollowingUsers, order);

        return new PostFollowingDTO(userId, postsListFollowingUsers);
    }

    @Override
    public int countProductPromoByUserId(int userId) throws UserNotExistsException {
        userService.userExists(userId);
        return postRepository.countProductPromoByUserId(userId);
    }

    @Override
    public ProductsUserDTO getProductsPromoPostByUserId(int userId, String order) throws UserNotExistsException {
        userService.userExists(userId);
        User user = userRepository.findById(userId);
        return new ProductsUserDTO(userId, user.getUserName(), getListPromoPostByUserId(userId));
    }

    private Post getPostById(int postId) {
        return postRepository.getPostByPostId(postId);
    }

    private void sortListByOrder(List<PostDTO> list, String order) {
        if (order.compareTo("date_asc") != 0) {
            sortList(list, comparatorDateDesc);
        } else {
            sortList(list, comparatorDateAsc);
        }
    }

    private void sortList(List<PostDTO> list, Comparator<PostDTO> comparator) {
        list.sort(comparator);
    }

    private boolean existsPost(int postId) {
        return getPostById(postId) != null;
    }

    public List<PostDTO> getListPromoPostByUserId(int userId) {
        return postRepository.getListPromoPostByUserId(userId).stream().map(PostMapper::modelToDTO).collect(Collectors.toList());
    }

}
