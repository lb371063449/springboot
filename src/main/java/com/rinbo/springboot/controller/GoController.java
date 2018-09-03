package com.rinbo.springboot.controller;

import com.rinbo.springboot.domain.User;
import com.rinbo.springboot.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

@Controller("goController")
public class GoController implements EnvironmentAware{

    @ModelAttribute("classname")
    public String setModel1() {
        return this.getClass().getName();
    }

    @ModelAttribute
    public void setModel2(Model model) {
        model.addAttribute("teacher","aa");
    }

    @ModelAttribute
    public String setModel3() {
        return "bbbb";
    }

    @Autowired
    private UserValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.addValidators(validator);
    }

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping(value = "/go")
    public String gooo() {
        return "test.html";
    }

    @RequestMapping(value = "/signup")
    public String signup(@Valid User user,Model model) {
        System.out.println(user);
        Map<String, Object> m = model.asMap();
        System.out.println(m);
        return "user.html";
    }

    @ResponseBody
    @RequestMapping(value = "/response")
    public String response() {
       return "xxxxxx";
    }

}
