package desafio1.demo.Exception;

import org.springframework.http.HttpStatus;

public class PromoPostWithoutPromoException extends ApiException{
    public PromoPostWithoutPromoException(int postId) {
        super("PromoPost ID:"+postId+" has no promo", HttpStatus.BAD_REQUEST);
    }
}
