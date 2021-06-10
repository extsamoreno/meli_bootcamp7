package socialmeli.socialmeli.project.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoNotFoundException;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IProductRepository;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.mapper.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Data
@AllArgsConstructor
@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void addNewPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoFoundException {
        if(postDto.isHasPromo()==true){
            throw new PostPromoFoundException(postDto);
        }
        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    @Override
    public void addNewPromoPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException {
        if(postDto.isHasPromo()!=true){
            throw new PostPromoNotFoundException(postDto);
        }

        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    @Override
    public PostArrayDto getArrayPostById(Integer userId, String order) throws NoPostsFoundException {
        ArrayList<Post> postArrayList = new ArrayList<>();
        postArrayList.addAll(iProductRepository.getArrayPostById(userId));

        if(order.equals("date_asc")){
            Collections.sort(postArrayList, Comparator.comparing(Post::getDate));
        }
        else if(order.equals("date_desc"))
        {
            Collections.sort(postArrayList, Comparator.comparing(Post::getDate));
            Collections.reverse(postArrayList);
        }

        return mapper.postArrayToDto(postArrayList);
    }



}
