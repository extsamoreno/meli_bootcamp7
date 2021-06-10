package desafio1.desafio1.service.productService;

import desafio1.desafio1.domain.Publications;
import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.publicationException.PublicatiosException;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.repository.IUserRepository;
import desafio1.desafio1.service.productService.dto.PostsDTO;
import desafio1.desafio1.service.productService.dto.PublicationDTO;
import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User newPost(PublicationDTO publicationDTO) throws UserNotFoundException, ValidateSellerException, PublicatiosException {

        User user = userRepository.findUserById(publicationDTO.getUserId());

        //Valid that the publication is not loaded
       if(!user.getPublicationsList().isEmpty()) {
           user.getPublicationsList().stream().filter(x -> x.getId_post() != publicationDTO.getId_post()).findFirst().orElseThrow(
                   () -> new PublicatiosException(publicationDTO.getId_post()));
       }

        Publications publications = new Publications();

       //Valid if I am a seller, otherwise I cannot upload publications.
        if(user.getIsSeller()==0){
            throw new ValidateSellerException(user.getUserId());
        }

        //I build the post that the seller posted.
        publications.setId_post(publicationDTO.getId_post());
        publications.setDate(publicationDTO.getDate());
        publications.setDetail(publicationDTO.getDetail());
        publications.setCategory(publicationDTO.getCategory());
        publications.setPrice(publicationDTO.getPrice());


        //I add that publication to the seller
        user.getPublicationsList().add(publications);

        return user;

    }

    @Override
    public PostsDTO listPublication(int userId, String order) throws UserNotFoundException {
        //I get the list of TDO sellers that the user follows
        List<UserSaveDTO> sellersTDO= userRepository.filterFollowers(userId, 1);
        List<User> sellers = new ArrayList<>();
        PostsDTO postsDTO = new PostsDTO();

        //I look for the list of complete seller objects, this has the list of publications
        for(int i=0 ; i< sellersTDO.size(); i++){
            sellers.add(userRepository.findUserById(sellersTDO.get(i).getUserId()));
        }

        postsDTO.setUserId(userId);
        postsDTO.setPosts(postsBefore(sellers, order));


        return postsDTO;

    }

    private List<Publications> postsBefore(List<User> sellers, String order) {
        Date dateMinusTwoWeeks = getDateBeforeTwoWeeks();

        List<Publications> posts = new ArrayList<>();

        for(User seller : sellers){
           posts = seller.getPublicationsList().stream().filter(
                    p -> p.getDate().after(dateMinusTwoWeeks)).collect(Collectors.toList());
        }

        if(order == null)  return posts;
        sortByDate(posts,order);

        return posts;

    }

    private void sortByDate(List<Publications> list , String order){
        if(order.equals("name_asc")) list.sort(Comparator.comparing(Publications::getDate));
        else if(order.equals("name_desc")) list.sort(Comparator.comparing(Publications::getDate).reversed());

    }


    private Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }


}
