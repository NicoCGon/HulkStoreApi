package com.todo1.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.todo1.api.entities.Product;

@Component
public class ProductValidator implements Validator{

	@Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"productName","El nombre del producto no puede estar vacio");
		ValidationUtils.rejectIfEmpty(errors,"und","La unidad no puede estar vacia");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"url","La url no puede estar vacia");
		ValidationUtils.rejectIfEmpty(errors,"stock","El stock no puede estar vacio");
    }
}
