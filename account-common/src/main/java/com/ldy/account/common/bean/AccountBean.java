package com.ldy.account.common.bean;

/**
 * Created by ldy on 2017/6/19.
 */

public class AccountBean {
    private String userName;

    public AccountBean(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AccountBean{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
