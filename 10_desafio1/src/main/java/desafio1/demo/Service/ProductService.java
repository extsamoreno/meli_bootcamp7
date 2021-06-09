package desafio1.demo.Service;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.PromoPostWithoutPromoException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Helper.HelperComparator;
import desafio1.demo.Model.DTO.*;
import desafio1.demo.Model.Entity.Post;
import desafio1.demo.Model.Entity.User;
import desafio1.demo.Repository.IRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService implements IProductService {
    IRepository iRepository;
    ModelMapper modelMapper;

    public ProductService(IRepository iRepository, ModelMapper modelMapper) {
        this.iRepository = iRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addNewPost(NewPostRequestDTO newPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException {
        var post = modelMapper.map(newPostRequestDTO, Post.class);
        iRepository.addNewPost(post);
    }

    @Override
    public void addNewPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException, PromoPostWithoutPromoException {
        if (!newPromoPostRequestDTO.isHasPromo() || newPromoPostRequestDTO.getDiscount() <= 0.0){
            throw new PromoPostWithoutPromoException(newPromoPostRequestDTO.getId_post());
        }
        var post = modelMapper.map(newPromoPostRequestDTO, Post.class);
        iRepository.addNewPost(post);
    }

    @Override
    public PostListFromFollowedDTO getPostListFromFollowed(int userId, String order) throws UserNotFoundException {
        var users = iRepository.getUserById(userId).getFollowedUsersList();
        var postStream = Stream.<Post>empty();
        for (User u: users) {
            postStream = Stream.concat(postStream,u.getPostList().stream()
                    .filter(post -> post.getDate().plusDays(12).isAfter(LocalDate.now()))            );
        }
        //Sort after concatenating all the recent posts from all the vendors in a single stream.
        var postList = postStream.sorted(HelperComparator.postDateComparatorDescDefault(order))
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .collect(Collectors.toList());

        return new PostListFromFollowedDTO(userId,postList);
    }

    @Override
    public PromoCountDTO getPromoCountDTOById(int userId) throws UserNotFoundException {
        var user = iRepository.getUserById(userId);
        var count = iRepository.getUserPromoPostsById(userId).count();
        return new PromoCountDTO(userId, user.getUserName(), count);
    }

    @Override
    public PromoListDTO getPromoListDTOById(int userId) throws UserNotFoundException {
        var user = iRepository.getUserById(userId);
        var postList = iRepository.getUserPromoPostsById(userId)
                .map(post -> modelMapper.map(post, PostResponseDTO.class))
                .collect(Collectors.toList());
        return new PromoListDTO(userId, user.getUserName(), postList);
    }
}
