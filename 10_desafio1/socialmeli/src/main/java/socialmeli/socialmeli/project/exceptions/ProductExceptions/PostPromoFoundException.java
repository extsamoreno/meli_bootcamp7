package socialmeli.socialmeli.project.exceptions.ProductExceptions;

import org.springframework.http.HttpStatus;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;

public class PostPromoFoundException extends ProductException {
    public PostPromoFoundException (PostDto postDto){
        super("ERROR: The postId: "+postDto.getIdPost()+" has a promo. Use newPromoPost endpoint instead", HttpStatus.BAD_REQUEST);
    }
}
