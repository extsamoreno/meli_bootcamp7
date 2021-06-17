package desafio2.testing.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseException extends Exception {

    private ErrorDTO error;
    private HttpStatus status;

}
