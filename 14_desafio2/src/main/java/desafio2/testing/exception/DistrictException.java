package desafio2.testing.exception;

import org.springframework.http.HttpStatus;

public class DistrictException extends HouseException {

    public DistrictException(Integer id) {
        super(new ErrorDTO("District error", "District "+id+" does not exist"), HttpStatus.BAD_REQUEST);
    }
}
