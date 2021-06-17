package desafio2.testing.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HouseException {

    public NotFoundException() {
        super(new ErrorDTO("Error", "Invalid data or does not exist"), HttpStatus.BAD_REQUEST);
    }
}