package com.rinbo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/book")
@SessionAttributes(value = {"book","description"},types = {Double.class})
public class BookController {

    @ModelAttribute("thisschool")
    public String setModel1() {
        return "this midschool";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("book","a-book");
        model.addAttribute("description","a-description");
        model.addAttribute("price",new Double(33.2));
        return "redirect:get";
    }

    @RequestMapping("/get")
    public String getBySesssionAttributes(@ModelAttribute("book") String book, ModelMap modelMap, SessionStatus status,Model model) {
            System.out.println("get attribute from @ModelAttribute :book " + book);
            System.out.println("get attribute form ModelMap start.....");
            System.out.println(modelMap.get("book"));
            System.out.println(modelMap.get("description"));
            System.out.println(modelMap.get("price"));

            System.out.println(model.asMap());
            System.out.println("get attribute form ModelMap start.....");
            status.setComplete();
            return "redirect:complet";
    }

    @RequestMapping("/complet")
    public String afterComplet(ModelMap modelMap) {
        System.out.println("============after SessionStatus complet =============");
        System.out.println("get attribute form ModelMap start.....");
        System.out.println(modelMap.get("book"));
        System.out.println(modelMap.get("description"));
        System.out.println(modelMap.get("price"));
        System.out.println("get attribute form ModelMap start.....");
        System.out.println(modelMap.get("school"));
        System.out.println(modelMap.get("thisschool"));
        return "/user.html";
    }

    @RequestMapping("/vpath/{path}")
    public String variablePath(@PathVariable String path) {
        System.out.println(path);
        return "/user.html";
    }
}
