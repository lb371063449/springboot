package com.rinbo.springboot.advice;

import com.rinbo.springboot.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class BaseAdvice {

    @Autowired
    private PasswordValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
//        binder.addValidators(validator);
    }

    @InitBinder
    protected void initBinder2(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }

    @ModelAttribute("school")
    public String setModel1() {
        return "midschool";
    }

    @ModelAttribute
    public void setModel2(Model model) {
        model.addAttribute("teacher","aa");
    }
}
