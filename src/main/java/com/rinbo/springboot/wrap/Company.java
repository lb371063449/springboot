package com.rinbo.springboot.wrap;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private String name;
    private Employee employee;
    private int[] peoples = new int[]{};
    private Map<String,String> attr = new HashMap<>();

    public int[] getPeoples() {
        return peoples;
    }

    public void setPeoples(int[] peoples) {
        this.peoples = peoples;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Map<String, String> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }
}
