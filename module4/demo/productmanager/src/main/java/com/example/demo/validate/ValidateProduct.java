package com.example.demo.validate;


import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;
@Component
public class ValidateProduct implements Validator {
    @Autowired
    ProductService productService;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        Date date = new Date();
        if(date.before(product.getDatePublish())){
            errors.rejectValue("datePublish","DateValidate",null,"Ngay ban khong duoc lon hon ngay hien tai");
        }
        if(productService.findByName(product.getName()).size()!=0){
            errors.rejectValue("name","nameValidate",null,"ten khong dc trung");
        }
    }

}
