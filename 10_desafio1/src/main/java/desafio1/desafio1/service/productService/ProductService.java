package desafio1.desafio1.service.productService;

import desafio1.desafio1.domain.Publications;
import desafio1.desafio1.domain.User;
import desafio1.desafio1.exception.userException.UserNotFoundException;
import desafio1.desafio1.exception.userException.ValidateSellerException;
import desafio1.desafio1.repository.IUserRepository;
import desafio1.desafio1.service.productService.dto.PostsDTO;
import desafio1.desafio1.service.productService.dto.PublicationDTO;
import desafio1.desafio1.service.userService.dto.UserSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public User newPost(PublicationDTO publicationDTO) throws UserNotFoundException, ValidateSellerException {
        User user = userRepository.findUserById(publicationDTO.getUserId()); //usuario que voy a manipilar

        Publications publications = new Publications();

        if(!user.getUserName().contains("vendedor")){  //Valido si yo soy un vendedor, sino no puedo cargar publicaciones
            throw new ValidateSellerException(user.getUserId());
        }

        //armo la publicacion que dio de alta el vendedor
        publications.setId_post(publicationDTO.getId_post());
        publications.setDate(publicationDTO.getDate());
        publications.setDetail(publicationDTO.getDetail()); //ojo porque estoy creando una nueva instancia y le seteo el producto que viene en el objeto por parametro
        publications.setCategory(publicationDTO.getCategory());
        publications.setPrice(publicationDTO.getPrice());

        //le agregago esa publicaicon al vendedor
        user.getPublicationsList().add(publications);

        return user;

    }

    @Override
    public PostsDTO listPublication(int userId) throws UserNotFoundException {
        //Obtengo la lista de vendedores TDO a los que sigue el usuario
        List<UserSaveDTO> sellersTDO= userRepository.filterFollowers(userId, "vendedor");
        List<User> sellers = new ArrayList<>();
        PostsDTO postsDTO = new PostsDTO();

        //obtengo la lista de objetos completo de seller, estos tienen la lista de publicaciones
        for(int i=0 ; i< sellersTDO.size(); i++){
            sellers.add(userRepository.findUserById(sellersTDO.get(i).getUserId()));
        }

        postsDTO.setUserId(userId);
        postsDTO.setPosts(postsBefore(sellers));

        return postsDTO;

    }

    private List<Publications> postsBefore(List<User> sellers) {
        Date dateMinusTwoWeeks = getDateBeforeTwoWeeks();

        List<Publications> posts = new ArrayList<>();

        for(User seller : sellers){
           posts = seller.getPublicationsList().stream().filter(
                    p -> p.getDate().after(dateMinusTwoWeeks)).collect(Collectors.toList());
        }

        return posts;
    }



    private Date getDateBeforeTwoWeeks() {
        Calendar calendar = Calendar.getInstance();
        calendar.getTime();
        calendar.add(Calendar.DATE, -14); //2 weeks
        return calendar.getTime();
    }


/*

    public PostListDTO getPostList(Integer userId) {
        List<UserDTO> listFollowed= repository.followedList(userId);
        List<PostDTO> listPost = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -2);

        for (UserDTO user: listFollowed) {
            listPost = Stream.concat(listPost.stream(), repository.findPostByUserId(user.getUserId()).stream())
                    .filter(post -> post.getDate().after(calendar.getTime()))
                    .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                    .collect(Collectors.toList());
        }

        return new PostListDTO(userId,listPost);
    }*/

}
