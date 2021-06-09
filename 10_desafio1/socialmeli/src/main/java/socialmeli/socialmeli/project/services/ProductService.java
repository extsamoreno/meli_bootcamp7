package socialmeli.socialmeli.project.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.repository.IProductRepository;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.mapper.mapper;

@Data
@AllArgsConstructor
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void addNewPost(PostDto postDto) throws PostAlreadyExistsException {

        iProductRepository.save(mapper.dtoToPost(postDto));
    }
    @Override
    public PostArrayDto getArrayPostById(Integer userId) throws NoPostsFoundException {
        return mapper.postArrayToDto(iProductRepository.getArrayPostById(userId));
    }

}
