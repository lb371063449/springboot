package com.rinbo.springboot.application;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.rinbo");
        Object goController = context.getBean("goController");
        System.out.println(goController);
    }
}
