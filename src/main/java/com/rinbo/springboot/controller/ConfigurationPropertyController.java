package com.rinbo.springboot.controller;

import com.rinbo.springboot.domain.configurationproperty.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableConfigurationProperties()
public class ConfigurationPropertyController {

    @Autowired
    People people;

    @RequestMapping("/configuration")
    @ResponseBody
    public People test() {
        return people;
    }
}
