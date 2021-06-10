package socialmeli.socialmeli.project.services;

import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;

public interface IProductService {
    public void addNewPost(PostDto PostDto) throws PostAlreadyExistsException;

    PostArrayDto getArrayPostById(Integer userId, String order) throws NoPostsFoundException;
}
