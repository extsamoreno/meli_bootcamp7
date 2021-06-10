package com.desafio_1.demo.services.validators;

import br.com.fluentvalidator.AbstractValidator;
import com.desafio_1.demo.dtos.ProductRequestDTO;
import java.util.Objects;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;

public class ProductValidator extends AbstractValidator<ProductRequestDTO> {

    @Override
    public void rules() {

        ruleFor(ProductRequestDTO::getDate)
                .must(Objects::nonNull)
                    .withMessage("La fecha es requerida.");

        ruleFor(ProductRequestDTO::getDetail)
                .must(Objects::nonNull)
                    .withMessage("El detalle de producto es requerido.");

        ruleFor(ProductRequestDTO::getCategory)
                .must(greaterThanOrEqual(1))
                    .withMessage("El id de categoria es invalido.");

        ruleFor(ProductRequestDTO::getPrice)
                .must(greaterThanOrEqual(1.0))
                    .withMessage("El precio debe ser mayor a 0.");

        ruleFor(ProductRequestDTO::getIdPost)
                .must(greaterThanOrEqual(1))
                    .withMessage("El id de post invalido.");

    }

}
