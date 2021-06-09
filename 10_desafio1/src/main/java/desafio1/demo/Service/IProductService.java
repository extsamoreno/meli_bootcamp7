package desafio1.demo.Service;

import desafio1.demo.Exception.DuplicatePostIDException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.NewPostDTO;
import desafio1.demo.Model.DTO.PostListFromFollowedDTO;

public interface IProductService{
    void addNewPost(NewPostDTO newPostDTO) throws DuplicatePostIDException, UserNotFoundException;
    PostListFromFollowedDTO getPostListFromFollowed(int userId) throws UserNotFoundException;
}
