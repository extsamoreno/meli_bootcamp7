package com.example.DesafioSpring.exceptions;

import com.example.DesafioSpring.dto.ErrorMsgDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UserException extends Exception {
    private ErrorMsgDTO errorMsg;
    private HttpStatus status;

    public UserException (String msg, HttpStatus status){
        this.errorMsg = new ErrorMsgDTO();
        this.errorMsg.setMessage(msg);
        this.errorMsg.setName(this.getClass().getSimpleName());
        this.status = status;
    }

}
