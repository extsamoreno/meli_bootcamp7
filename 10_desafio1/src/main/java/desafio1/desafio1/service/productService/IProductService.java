package desafio1.desafio1.service.productService;

import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.service.productService.dto.PostsDTO;
import desafio1.desafio1.service.productService.dto.PublicationDTO;

public interface IProductService {
    User newPost(PublicationDTO publicationDTO) throws UserNotFoundException, ValidateSellerException;

    PostsDTO listPublication(int userId, String order) throws UserNotFoundException;
}
