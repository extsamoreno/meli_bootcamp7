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


    //Add a new post
    @Override
    public void addNewPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoFoundException, IdNotFoundException, InvalidPostDateException {
        if(postDto.isHasPromo()) //If post has a promo
            throw new PostPromoFoundException(postDto);

        LocalDate localDate = postDto.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateNow = LocalDate.now();
        if(!localDate.isBefore(localDateNow)) //If post date is after than actual date
            throw new InvalidPostDateException(postDto);

        if(iUserRepository.findUserById(postDto.getUserId())!=null) //If userId does not exists in repository
        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    //Add a new promo post
    @Override
    public void addNewPromoPost(PostDto postDto) throws PostAlreadyExistsException, PostPromoNotFoundException, IdNotFoundException {
        if(!postDto.isHasPromo()){ //If post has not a promo
            throw new PostPromoNotFoundException(postDto);
        }
        if(iUserRepository.findUserById(postDto.getUserId())!=null) //If userId does not exists in repository
        iProductRepository.save(mapper.dtoToPost(postDto));
    }

    //Get Post array by userId
    @Override
    public PostArrayDto getArrayPostById(Integer userId, String order) throws NoPostsFoundException, IdNotFoundException {
        ArrayList<User> userFollowedList =iUserRepository.getUserFollowedList(userId); //Get userId followed list

        ArrayList<Post> postArrayList = new ArrayList<>();

        for (User userFollowed:userFollowedList) { //Foreach userFollowed, get their list of posts
            postArrayList.addAll(iProductRepository.getArrayPostById(userFollowed.getUserId()));
        }

        Collections.sort(postArrayList, Comparator.comparing(Post::getDate)); //Sort asc
        if(order.equals("date_desc"))
            Collections.reverse(postArrayList); //Sort desc

        return mapper.postArrayToDto(postArrayList);
    }

    //Get count number of promos
    @Override
    public PostPromoDto getCountPromo(Integer userId) throws IdNotFoundException {
        ArrayList<Post> promoArr = iProductRepository.getArrayPromoPostById(userId); //Get userId promo postlist
        User user = iUserRepository.findUserById(userId);
        return mapper.postArrayPromoToDto(user.getUserId(),user.getUserName(),promoArr);
    }

    //Get Post promo list by userId
    @Override
    public PostPromoListDto getPostPromoList(Integer userId, String order){
        ArrayList<Post> promoArr = iProductRepository.getArrayPromoPostById(userId); //Get userId promo postlist

        Collections.sort(promoArr, Comparator.comparing(Post::getDetail)); //Sort asc
        if(order.equals("productname_desc"))
         Collections.reverse(promoArr); //Sort desc

        return mapper.postArrayPromoToListDto(promoArr);
    }


}
