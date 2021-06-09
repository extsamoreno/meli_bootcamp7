package socialmeli.socialmeli.project.services;

import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.ProductDto;

public interface IProductService {
    public void addNewPost(PostDto PostDto) throws PostAlreadyExistsException;

}
