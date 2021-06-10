package socialmeli.socialmeli.project.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.NoPostsFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostAlreadyExistsException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoFoundException;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.PostPromoNotFoundException;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IProductRepository;
import socialmeli.socialmeli.project.repository.IUserRepository;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;
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
    IUserRepository iUserRepository;

    @Override
    public void addNewPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException {
        if(postDto.isHasPromo()==true){
            throw new PostPromoFoundException(postDto);
        }
        if(iUserRepository.findUserById(postDto.getUserId())!=null)
        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    @Override
    public void addNewPromoPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException, IdNotFoundException {
        if(postDto.isHasPromo()!=true){
            throw new PostPromoNotFoundException(postDto);
        }
        if(iUserRepository.findUserById(postDto.getUserId())!=null)
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

    @Override
    public PostPromoDto getCountPromo(Integer userId) throws IdNotFoundException {
        ArrayList<Post> promoArr = iProductRepository.getArrayPromoPostById(userId);
        User user = iUserRepository.findUserById(userId);
        return mapper.postArrayPromoToDto(user.getUserId(),user.getUserName(),promoArr);
    }


}
