package desafio1.demo.Service;

import desafio1.demo.Exception.DuplicatePostIdException;
import desafio1.demo.Exception.PromoPostWithoutPromoException;
import desafio1.demo.Exception.UserNotFoundException;
import desafio1.demo.Model.DTO.*;

public interface IProductService{
    void addNewPost(NewPostRequestDTO newPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException;
    void addNewPromoPost(NewPromoPostRequestDTO newPromoPostRequestDTO) throws DuplicatePostIdException, UserNotFoundException, PromoPostWithoutPromoException;
    PostListFromFollowedDTO getPostListFromFollowed(int userId, String order) throws UserNotFoundException;
    PromoCountDTO getPromoCountDTOById(int userId) throws UserNotFoundException;
    PromoListDTO getPromoListDTOById(int userId) throws UserNotFoundException;
}
