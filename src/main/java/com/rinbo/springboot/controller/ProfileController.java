package com.rinbo.springboot.controller;


import com.rinbo.springboot.bean.IProBean;
import com.rinbo.springboot.properties.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    @Value("${libo.name}")
    private String name;

    @Autowired
    Config config;

    @Autowired
    IProBean proBean;

    @GetMapping("/profile/getname")
    public String getName() {
        return name;
    }

    @GetMapping("/profile/getserver")
    public List getServer() {
        return config.getServers();
    }

    @GetMapping("/profile/getpro")
    public String getpro() {
        return proBean.getName();
    }

}
