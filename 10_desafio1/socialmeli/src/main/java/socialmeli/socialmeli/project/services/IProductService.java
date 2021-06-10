package socialmeli.socialmeli.project.services;

import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoNotFoundException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;

public interface IProductService {
    public void addNewPost(PostDto PostDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException;

    PostArrayDto getArrayPostById(Integer userId, String order) throws NoPostsFoundException;

    void addNewPromoPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException, IdNotFoundException;

    PostPromoDto getCountPromo(Integer userId) throws IdNotFoundException;
}
