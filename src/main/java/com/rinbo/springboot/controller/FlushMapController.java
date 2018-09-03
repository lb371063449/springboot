package com.rinbo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/flush")
public class FlushMapController {

    @RequestMapping("/submit")
    public String submit(RedirectAttributes attr) {
        FlashMap flashMap = (FlashMap) RequestContextHolder.getRequestAttributes().getAttribute(DispatcherServlet.OUTPUT_FLASH_MAP_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
        flashMap.put("name","Rinbo");
        attr.addAttribute("name2","rinbo2");
        attr.addFlashAttribute("name3","rinbo3");
        return "redirect:test";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        System.out.println(model.asMap());
        return "/test.html";
    }
}
