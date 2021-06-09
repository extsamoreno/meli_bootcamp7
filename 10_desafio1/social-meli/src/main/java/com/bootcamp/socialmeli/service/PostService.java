package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.ListFollowedPostDTO;
import com.bootcamp.socialmeli.DTO.PostRequestDTO;
import com.bootcamp.socialmeli.exception.PostAlreadyRegisteredException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.mapper.PostMapper;
import com.bootcamp.socialmeli.model.Post;
import com.bootcamp.socialmeli.model.User;
import com.bootcamp.socialmeli.repository.IDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    IDataRepository dataRepository;

    @Autowired
    PostMapper postMapper;

    @Override
    public void newPost(PostRequestDTO post) throws UserIdNotFoundException, PostAlreadyRegisteredException {
        dataRepository.newPost(postMapper.toPost(post));
    }

    @Override
    public ListFollowedPostDTO getFollowedPost(Integer userId) throws UserIdNotFoundException {

        User user = dataRepository.findUserById(userId);
        List<Integer> followed = user.getFollowed();
        List<Post> postFollowed = new ArrayList<>();

        for (Integer f : followed) {
            User userAux = dataRepository.findUserByIdWithoutException(f);

            for (Integer p : userAux.getPosts()) {
                postFollowed.add(dataRepository.findPostById(p));
            }
        }

        postFollowed.sort((p1, p2) -> p1.getDate().compareTo(p2.getDate()));

        return postMapper.toListFollowedPostDTO(postFollowed, userId);
        /*//Sort by date
        Comparator<Publication> publicationDateComparator = Comparator.comparing(Publication::getDate).reversed();
        publications.sort(publicationDateComparator);*/
    }
}
