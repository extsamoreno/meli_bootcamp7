package desafio2.demo.exception;

import desafio2.demo.model.DistrictDTO;
import org.springframework.http.HttpStatus;

public class DistrictNotFoundException extends ApiException{
    public DistrictNotFoundException(DistrictDTO district) {
        super("District " + district.getName() + " with price " + district.getPrice() + "USD was not found", HttpStatus.NOT_FOUND);
    }
}
