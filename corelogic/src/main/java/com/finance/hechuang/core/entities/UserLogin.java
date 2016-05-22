package com.finance.hechuang.core.entities;

/**
 * Created by ww on 16-5-16.
 *
 * class to store user info needed to login
 *
 */
public class UserLogin {

    public String userId;
    public String pass;

    public UserLogin(String userId, String pass){
        this.userId=userId;
        this.pass=pass;
    }

    @Override
    public boolean equals(Object obj) {
        UserLogin objUserLogin =(UserLogin)obj;
        return (userId.equals(objUserLogin.userId))&&(pass.equals(objUserLogin.pass));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new UserLogin(userId,pass);
    }
}
