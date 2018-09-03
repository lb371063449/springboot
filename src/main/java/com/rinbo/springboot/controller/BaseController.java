package com.rinbo.springboot.controller;

import com.rinbo.springboot.domain.Bean;
import com.rinbo.springboot.domain.MutilUser;
import com.rinbo.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/base")
public class BaseController {

    @RequestMapping(value = "/regit")
    public String regit() {
        return "/register.html";
    }

    @RequestMapping(value = "/add")
    public String add(int id, String name, double sal, Date hiredate, Model model) throws Exception {
        System.out.println("HelloAction::add()::POST");
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("sal", sal);
        model.addAttribute("hiredate", hiredate);
        System.out.println(id + "=========" + name);
        return "/test.html";
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public User addUser(User user, Model model) throws Exception {
        model.addAttribute("user",user);
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/tomutiluser")
    public String tomutiluser() {
        return "/mutiluser.html";
    }


    @RequestMapping(value = "/mutiluser")
    @ResponseBody
    public Bean addMutilUser(Bean bean,String[] id) throws Exception {
        for(MutilUser user : bean.getUserList()){
            System.out.println(user.getName()+":"+user.getGender());
        }
        for (String i :id) {
            System.out.println(i);
        }
        return bean;
    }
}
