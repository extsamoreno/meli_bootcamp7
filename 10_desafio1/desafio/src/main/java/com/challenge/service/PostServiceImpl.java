package com.challenge.service;

import com.challenge.dto.NewPostRequest;
import com.challenge.dto.NewPromoPostRequest;
import com.challenge.entity.Post;
import com.challenge.entity.User;
import com.challenge.enums.SortingPostsEnum;
import com.challenge.enums.SortingUserEnum;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;
import com.challenge.repository.PostRepository;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Post> getRecentPosts(Integer id, SortingPostsEnum sorting) throws UserIdNotFoundException {
        List<Integer> followedIds = userRepository.getFollowedIds(id);
        List<Post> recentPosts = postRepository.getRecentPosts(followedIds, LocalDate.now().minusWeeks(2));
        if (sorting == null || sorting.equals(SortingPostsEnum.date_asc)) {
            recentPosts.sort(Comparator.comparing(Post::getDate).reversed());
        } else if (sorting.equals(SortingPostsEnum.date_desc)) {
            recentPosts.sort(Comparator.comparing(Post::getDate));

        }
        return recentPosts;
    }

    @Override
    public void addNewPost(NewPostRequest request) throws PostIdAlreadyExistsException, UserIdNotFoundException, IOException {
        User user = userRepository.getUserById(request.getUserId());
        if (user == null) {
            throw new UserIdNotFoundException();
        }
        if (request instanceof NewPromoPostRequest) {
            postRepository.addNewProduct(PostMapper.toPromoPost((NewPromoPostRequest) request));
        } else {
            postRepository.addNewProduct(PostMapper.toPost(request));
        }
    }
}
