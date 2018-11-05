package com.rinbo.springboot.wrap;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Map;

public class WrapTest {

    public static void main(String[] args) {
        Company c = new Company();
        BeanWrapper company = new BeanWrapperImpl(c);
        company.setPropertyValue("attr[name]", "libo");
        company.setPropertyValue("name", "Some Company Inc.");
        company.setPropertyValue("peoples[0]", 1);
        company.setPropertyValue("employee", new Employee());

        company.setPropertyValue("employee.salary", 22.3f);

        Map<String,String> attr = (Map<String, String>) company.getPropertyValue("attr");
        System.out.println(attr.get("name"));

        Float salary = (Float) company.getPropertyValue("employee.salary");
        System.out.println(salary);
    }
}
