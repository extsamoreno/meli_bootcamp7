package desafio1.demo.Service;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.PromoPostWithoutPromoException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.NewPostRequestDTO;
import desafio1.demo.Model.DTO.NewPromoPostRequestDTO;
import desafio1.demo.Model.DTO.PostListFromFollowedDTO;
import desafio1.demo.Model.DTO.PromoCountDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface IProductService{
    void addNewPost(NewPostRequestDTO newPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException;
    void addNewPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException, PromoPostWithoutPromoException;
    PostListFromFollowedDTO getPostListFromFollowed(int userId, String order) throws UserNotFoundException;
    PromoCountDTO getPromoCountDTOById(@PathVariable int userId) throws UserNotFoundException;
}
