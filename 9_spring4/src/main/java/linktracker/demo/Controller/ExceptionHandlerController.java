package linktracker.demo.Controller;

import linktracker.demo.Exception.LinkAlreadyPresentException;
import linktracker.demo.Exception.LinkException;
import linktracker.demo.Model.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorDTO> returnError(LinkException e){
        return new ResponseEntity<>(e.getErrorDTO(),e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> returnError(Exception e){
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
