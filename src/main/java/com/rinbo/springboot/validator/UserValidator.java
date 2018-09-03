package com.rinbo.springboot.validator;

import com.rinbo.springboot.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getName().length()<3) {
            errors.rejectValue("name","must dayu 8");
        }
    }
}
