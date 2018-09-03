package com.rinbo.springboot.domain;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private Double sal;
    private Date hiredate;

    public User(Integer id, String name, Double sal, Date hiredate) {
        this.id = id;
        this.name = name;
        this.sal = sal;
        this.hiredate = hiredate;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                ", hiredate=" + hiredate +
                '}';
    }
}
