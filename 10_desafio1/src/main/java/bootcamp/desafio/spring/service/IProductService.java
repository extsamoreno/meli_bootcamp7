package bootcamp.desafio.spring.service;

import bootcamp.desafio.spring.exception.DateException;
import bootcamp.desafio.spring.exception.PostException;
import bootcamp.desafio.spring.exception.PostUserNotFoundException;
import bootcamp.desafio.spring.model.Post;
import bootcamp.desafio.spring.service.dto.CantPromoDTO;
import bootcamp.desafio.spring.service.dto.PostPromoListDTO;
import bootcamp.desafio.spring.service.dto.PostRequestDTO;
import bootcamp.desafio.spring.service.dto.ProductFollowedDTO;

import java.util.ArrayList;

public interface IProductService {

    void addNewPost(PostRequestDTO post) throws PostUserNotFoundException, DateException;

    ProductFollowedDTO getPostTheFollows(Long userId, String order);

    ArrayList<Post> getAll();

    void addNewPostPromo(PostRequestDTO post) throws PostException, DateException;

    CantPromoDTO getPromosBySeller(Long userId) throws PostUserNotFoundException;

    PostPromoListDTO getPromosBySellerList(Long userId) throws PostUserNotFoundException;
}
