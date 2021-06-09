package com.socialmeli.socialmeli.services;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.exceptions.UserNotFoundException;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.UserRepository;
import com.socialmeli.socialmeli.services.dtos.ListPostDTO;
import com.socialmeli.socialmeli.services.dtos.PostDTO;
import com.socialmeli.socialmeli.services.mappers.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void newPost(PostDTO post) throws UserNotFoundException, PostIdAlreadyExistException, DateIsNotValidException {
        userRepository.insertPost(
                PostMapper.getPost(post)
        );
    }

    @Override
    public ListPostDTO getFollowedPostList(int userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        List<PostDTO> followedPostDTOList = new ArrayList<>();

        for (User userFollowed: user.getFollowed()
             ) {
            for (Post post: userFollowed.getPosts()
                 ) {
                followedPostDTOList.add(
                        PostMapper.getPostDTO(post)
                );
            }
        }

        //Sort by date
        Comparator<PostDTO> postDateComparator = Comparator.comparing(PostDTO::getDate).reversed();
        followedPostDTOList.sort(postDateComparator);

        return new ListPostDTO(userId,followedPostDTOList);
    }


}
