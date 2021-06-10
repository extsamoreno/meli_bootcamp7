package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.response.ListOfFollowedPostsDTOres;
import com.bootcamp.socialmeli.DTO.request.PostDTOreq;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.mapper.PostMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IDataRepository;
import com.bootcamp.socialmeli.util.DateUtilities;
import com.bootcamp.socialmeli.util.SortUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    IDataRepository dataRepository;

    @Autowired
    PostMapper postMapper;

    @Autowired
    SortUtilities sortUtilities;

    @Autowired
    DateUtilities dateUtilities;

    @Override
    public void newPost(PostDTOreq postDTOreq) throws PostAlreadyRegisteredException, UserIdNotFoundException {
        User user = dataRepository.findUserById(postDTOreq.getUserId());
        if (user == null) {
            throw new UserIdNotFoundException(postDTOreq.getUserId());
        }

        Post post = postMapper.toPost(postDTOreq);

        List<Post> posts = dataRepository.getAllPost();

        //Controlo si ya existe un post con ese id
        if (dataRepository.findPostById(post.getPostId()) != null) {
            throw new PostAlreadyRegisteredException(post.getPostId());
        }

        posts.add(post);

        //Agrego el nuevo post a los post del usuario si es que este no existe
        if (!user.getPosts().contains(post.getPostId())) {
            user.getPosts().add(post.getPostId());
        }
    }

    @Override
    public ListOfFollowedPostsDTOres getFollowedPost(Integer userId, Optional<String> order) throws UserIdNotFoundException {
        if (dataRepository.findUserById(userId) == null) {
            throw new UserIdNotFoundException(userId);
        }

        List<User> usersFollowed = dataRepository.getUserFollowed(userId);
        List<Post> postFollowed = new ArrayList<>();

        for (User userAux : usersFollowed) {
            for (Integer p : userAux.getPosts()) {
                postFollowed.add(dataRepository.findPostById(p));
            }
        }

        sortUtilities.sortListOfPosts(postFollowed, order);

        //Filtro los post si son posteriores a dos semanas
        postFollowed = postFollowed
                .stream()
                .filter(p -> p.getDate().isAfter(dateUtilities.getTwoWeeksAgo()))
                .collect(Collectors.toList());

        return postMapper.toListOfFollowedPostDTO(postFollowed, userId);
    }
}
