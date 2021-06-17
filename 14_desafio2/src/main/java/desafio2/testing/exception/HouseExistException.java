package desafio2.testing.exception;

import org.springframework.http.HttpStatus;

public class HouseExistException extends HouseException {

    public HouseExistException() {
        super(new ErrorDTO("Error", "The house already exists"), HttpStatus.BAD_REQUEST);
    }
}
