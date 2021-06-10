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

    @Override
    public void newPost(PostDTOreq postDTOreq) throws PostAlreadyRegisteredException, UserIdNotFoundException {
        User user = dataRepository.findUserById(postDTOreq.getUserId());
        Post post = postMapper.toPost(postDTOreq);

        List<Post> posts = dataRepository.getAllPost();
        //Controlo si ya existe un post con ese id
        Post postControl = posts.stream()
                .filter(postAux -> postAux.getPostId() == post.getPostId())
                .findFirst()
                .orElse(null);

        if (postControl != null) {
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

        User user = dataRepository.findUserById(userId);
        List<Integer> followed = user.getFollowed();
        List<Post> postFollowed = new ArrayList<>();

        for (Integer f : followed) {
            User userAux = dataRepository.findUserByIdWithoutException(f);

            for (Integer p : userAux.getPosts()) {
                postFollowed.add(dataRepository.findPostById(p));
            }
        }

        sortUtilities.sortListOfPosts(postFollowed, order);

        //Filtro los post si son posteriores a dos semanas
        postFollowed = postFollowed
                .stream()
                .filter(p -> p.getDate().isAfter(DateUtilities.twoWeeksAgo))
                .collect(Collectors.toList());

        return postMapper.toListOfFollowedPostDTO(postFollowed, userId);
    }
}
