package meli.social.exception;

import org.springframework.http.HttpStatus;

public class PostIdRepeatedException extends PostException {
        public PostIdRepeatedException(Integer postId) {
            super("No se puede realizar un pedido con el id:"+ postId, HttpStatus.CONFLICT);
        }
}

