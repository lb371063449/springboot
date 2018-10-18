package com.rinbo.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Profile1Bean {

    @Bean
    public IProBean getIProBean() {
        return new IProBean(){

            @Override
            public String getName() {
                return "dev";
            }
        };
    }
}
