package com.desafio_1.demo.services.validators;

import br.com.fluentvalidator.AbstractValidator;
import com.desafio_1.demo.dtos.ProductDetailDTO;
import java.util.function.Predicate;
import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;

public class ProductDetailValidator extends AbstractValidator<ProductDetailDTO> {

    @Override
    public void rules() {

        ruleFor(ProductDetailDTO::getProductId)
                .must(greaterThanOrEqual(1))
                .withMessage("El id de producto es invalido.");

        ruleFor(ProductDetailDTO::getProductName)
                .must(Predicate.not(String::isBlank))
                .withMessage("El nombre del producto es requerido.");

        ruleFor(ProductDetailDTO::getBrand)
                .must(Predicate.not(String::isBlank))
                .withMessage("La marca del producto es requerida.");

        ruleFor(ProductDetailDTO::getColor)
                .must(Predicate.not(String::isBlank))
                .withMessage("El color del producto es requerido.");

        ruleFor(ProductDetailDTO::getType)
                .must(Predicate.not(String::isBlank))
                .withMessage("El tipo de producto es requerido.");

        ruleFor(ProductDetailDTO::getNotes)
                .must(Predicate.not(String::isBlank))
                .withMessage("Las notas del producto son requeridas.");

    }
}
