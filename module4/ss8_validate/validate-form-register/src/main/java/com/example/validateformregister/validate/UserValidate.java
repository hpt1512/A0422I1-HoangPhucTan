package com.example.validateformregister.validate;

import com.example.validateformregister.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length", new String[]{"10"}, "Số điện thoại không đúng định dạng");
        } else if (!user.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.start", "Số điện thoại không đúng định dạng");
        }
    }
}
