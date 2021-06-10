package socialmeli.socialmeli.project.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialmeli.socialmeli.project.exceptions.ProductExceptions.*;
import socialmeli.socialmeli.project.exceptions.UserExceptions.IdNotFoundException;
import socialmeli.socialmeli.project.models.Post;
import socialmeli.socialmeli.project.models.Product;
import socialmeli.socialmeli.project.models.User;
import socialmeli.socialmeli.project.repository.IProductRepository;
import socialmeli.socialmeli.project.repository.IUserRepository;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostArrayDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoDto;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostPromoListDto;
import socialmeli.socialmeli.project.services.mapper.mapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;
    IUserRepository iUserRepository;

    @Override
    public void addNewPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException, InvalidPostDateException {
        if(postDto.isHasPromo())
            throw new PostPromoFoundException(postDto);

        LocalDate localDate = postDto.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateNow = LocalDate.now();
        if(!localDate.isBefore(localDateNow))
            throw new InvalidPostDateException(postDto);

        if(iUserRepository.findUserById(postDto.getUserId())!=null)
        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    @Override
    public void addNewPromoPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException, IdNotFoundException {
        if(!postDto.isHasPromo()){
            throw new PostPromoNotFoundException(postDto);
        }
        if(iUserRepository.findUserById(postDto.getUserId())!=null)
        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    @Override
    public PostArrayDto getArrayPostById(Integer userId, String order) throws NoPostsFoundException {
        ArrayList<Post> postArrayList = new ArrayList<>();
        postArrayList.addAll(iProductRepository.getArrayPostById(userId));

        Collections.sort(postArrayList, Comparator.comparing(Post::getDate));
        if(order.equals("date_desc"))
            Collections.reverse(postArrayList);

        return mapper.postArrayToDto(postArrayList);
    }

    @Override
    public PostPromoDto getCountPromo(Integer userId) throws IdNotFoundException {
        ArrayList<Post> promoArr = iProductRepository.getArrayPromoPostById(userId);
        User user = iUserRepository.findUserById(userId);
        return mapper.postArrayPromoToDto(user.getUserId(),user.getUserName(),promoArr);
    }

    @Override
    public PostPromoListDto getPostPromoList(Integer userId, String order){
        ArrayList<Post> promoArr = iProductRepository.getArrayPromoPostById(userId);

        Collections.sort(promoArr, Comparator.comparing(Post::getDetail));
        if(order.equals("productname_desc"))
         Collections.reverse(promoArr);

        return mapper.postArrayPromoToListDto(promoArr);
    }


}
