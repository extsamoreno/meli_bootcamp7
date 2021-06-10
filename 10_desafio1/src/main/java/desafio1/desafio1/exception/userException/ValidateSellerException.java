package desafio1.desafio1.exception.userException;

import desafio1.desafio1.service.ErrorDTO;
import org.springframework.http.HttpStatus;

public class ValidateSellerException extends UserException {

    public ValidateSellerException(Integer userId){
        super(new ErrorDTO("Seller Not Found", "There is no seller with id: "+userId), HttpStatus.BAD_REQUEST);
    }
}
