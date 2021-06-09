package desafio1.demo.Service;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Helper.HelperComparator;
import desafio1.demo.Model.DTO.NewPostDTO;
import desafio1.demo.Model.DTO.PostListFromFollowedDTO;
import desafio1.demo.Model.Entity.Post;
import desafio1.demo.Model.Entity.User;
import desafio1.demo.Repository.IRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
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
    public void addNewPost(NewPostDTO newPostDTO) throws DuplicatePostIdException, UserNotFoundException {
        var post = modelMapper.map(newPostDTO, Post.class);
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
        var postList = postStream.sorted(HelperComparator.postDateComparatorDescDefault(order))
                .map(post -> modelMapper.map(post,NewPostDTO.class))
                .collect(Collectors.toList());

        return new PostListFromFollowedDTO(userId,postList);
    }
}
