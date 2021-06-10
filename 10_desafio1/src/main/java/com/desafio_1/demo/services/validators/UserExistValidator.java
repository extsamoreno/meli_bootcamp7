package com.desafio_1.demo.services.validators;

import br.com.fluentvalidator.AbstractValidator;
import com.desafio_1.demo.models.User;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;

public class UserExistValidator extends AbstractValidator<User> {


    @Override
    public void rules() {

        ruleFor(User::getId)
                .must(greaterThanOrEqual(1))
                    .withMessage("El usuario con el id ingresado no existe.");
    }
}
