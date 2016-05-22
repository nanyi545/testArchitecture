package com.finance.hechuang.core.entities;

/**
 * Created by ww on 16-5-21.
 *
 * keep track of login status
 *
 */
public class LoginStatus {

    private UserLogin login;
    public synchronized UserLogin getLogin(){
        return login;
    }

    /**  constructors **/
    public LoginStatus(){

    }
    public LoginStatus(UserLogin login){
        this.login=login;
    }

    public synchronized void updateLogin(UserLogin login){
        this.login = login;
    }

    public synchronized boolean isLogin(){
        return (!(login==null));
    }





}
