package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.*;
import com.socialmeli.socialmeli.services.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        userRepository.insertPost(
                PostMapper.getPostFromPostDTO(post)
        );
    }

    @Override
    public void newPromoPost(PostPromoDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        userRepository.insertPost(
                PostMapper.getPostFromPostPromoDTO(post)
        );
    }

    @Override
    public ListPostDTO getFollowedPostList(int userId, Optional<String> order) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<PostDTO> followedPostDTOList = new ArrayList<>();

        for (User userFollowed: user.getFollowed()
             ) {
            for (Post post: userFollowed.getPosts()
                 ) {
                followedPostDTOList.add(
                        PostMapper.getPostDTOFromPost(post)
                );
            }
        }

        Comparator<PostDTO> postDateComparator = Comparator.comparing(PostDTO::getDate).reversed();
        if(order.isPresent()){
            switch (order.get()){
                case "date_asc": postDateComparator = Comparator.comparing(PostDTO::getDate);
                    break;
                case "date_desc" : postDateComparator = Comparator.comparing(PostDTO::getDate).reversed();
                    break;
            }
        }
        followedPostDTOList.sort(postDateComparator);

        return new ListPostDTO(userId,followedPostDTOList);
    }

    @Override
    public ProductUserPromoDTO getProductPromoCount(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        int count = (int) user.getPosts().stream().filter(Post::isHasPromo).count();
        return new ProductUserPromoDTO(
                userId,
                user.getUserName(),
                count
        );
    }

    @Override
    public ListPostPromoDTO getProductsPromo(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        return new ListPostPromoDTO(
                userId,
                user.getUserName(),
                PostMapper.getPostPromoListFromPostList(
                        user.getPosts().stream().filter(Post::isHasPromo).collect(Collectors.toList())
                ));
    }


}
