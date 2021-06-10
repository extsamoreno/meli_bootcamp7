package socialmeli.socialmeli.project.services;

import socialmeli.socialmeli.project.exceptions.ProductExceptions.*;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoListDto;

public interface IProductService {
    void addNewPost(PostDto PostDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException, InvalidPostDateException;
    PostArrayDto getArrayPostById(Integer userId, String order) throws NoPostsFoundException, IdNotFoundException;
    void addNewPromoPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException, IdNotFoundException;
    PostPromoDto getCountPromo(Integer userId) throws IdNotFoundException;
    PostPromoListDto getPostPromoList(Integer userId, String order);
}
