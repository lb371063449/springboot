package com.rinbo.springboot.domain;

public class MutilUser {

    private String name;
    private String gender;

    public MutilUser() {
    }

    @Override
    public String toString() {
        return "MutilUser{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MutilUser(String name, String gender) {

        this.name = name;
        this.gender = gender;
    }
}
