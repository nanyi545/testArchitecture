package com.finance.hechuang.core.entities;

/**
 * Created by Administrator on 16-5-16.
 */
public class User {
    public String userId;
    public String pass;

    public User(String userId,String pass){
        this.userId=userId;
        this.pass=pass;
    }

    @Override
    public boolean equals(Object obj) {
        User objUser=(User)obj;
        return (userId.equals(objUser.userId))&&(pass.equals(objUser.pass));
    }
}
