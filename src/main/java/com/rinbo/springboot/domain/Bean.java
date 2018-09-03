package com.rinbo.springboot.domain;

import java.util.ArrayList;
import java.util.List;

public class Bean {
    private List<MutilUser> userList = new ArrayList<MutilUser>();
    public Bean(){}

    public List<MutilUser> getUserList() {
        return userList;
    }
    public void setUserList(List<MutilUser> userList) {
        this.userList = userList;
    }
}