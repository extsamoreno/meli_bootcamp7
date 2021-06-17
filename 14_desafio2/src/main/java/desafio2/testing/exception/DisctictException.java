package desafio2.testing.exception;

import org.springframework.http.HttpStatus;

public class DisctictException extends HouseException {

    public DisctictException(Integer id) {
        super(new ErrorDTO("District error", "District "+id+" does not exist"), HttpStatus.BAD_REQUEST);
    }
}
