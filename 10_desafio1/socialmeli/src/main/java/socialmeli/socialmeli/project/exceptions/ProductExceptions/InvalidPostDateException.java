package socialmeli.socialmeli.project.exceptions.ProductExceptions;

import org.springframework.http.HttpStatus;
import socialmeli.socialmeli.project.services.Dto.ProductDto.PostDto;

public class InvalidPostDateException extends ProductException{

    public InvalidPostDateException(PostDto postDto){
        super("ERROR. The postId: "+postDto.getIdPost()+" has an invalid date. It has to be less than the current one", HttpStatus.BAD_REQUEST);

    }
}
