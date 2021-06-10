package com.desafio_1.demo.services.helpers;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;
import com.desafio_1.demo.exceptions.BadRequestException;
import com.desafio_1.demo.models.User;
import com.desafio_1.demo.services.validators.UserExistValidator;

public class UserValidatorHelper {

    public static void validateUserExist(User user) throws BadRequestException{
        Validator<User> validator = new UserExistValidator();
        ValidationResult result = validator.validate(user);
        if(!result.isValid()){
            throw new BadRequestException(result.getErrors().toString());
        }
    }
}
