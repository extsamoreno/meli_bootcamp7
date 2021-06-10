package socialmeli.socialmeli.project.exceptions.ProductExceptions;

import org.springframework.http.HttpStatus;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;

public class PostPromoNotFoundException extends ProductException{

    public PostPromoNotFoundException (PostDto postDto){
        super("ERROR: The post "+postDto.getIdPost()+" has no promo", HttpStatus.BAD_REQUEST);
    }
}
