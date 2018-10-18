package com.rinbo.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("product")
public class Profile2Bean {

    @Bean
    public IProBean getIProBean() {
        return new IProBean(){

            @Override
            public String getName() {
                return "product";
            }
        };
    }
}
