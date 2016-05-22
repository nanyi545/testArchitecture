package com.finance.hechuang.serviceonline;

import com.finance.hechuang.core.entities.LoginStatus;
import com.finance.hechuang.core.entities.UserLogin;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 16-5-21.
 */
public class LoginTest {

    @Test
    public void test1() {
        LoginStatus status=new LoginStatus();
        status.updateLogin(new UserLogin("123","456"));
        boolean loggedIn=status.isLogin();
        assertTrue(loggedIn);
    }


    @Test
    public void test2() {
        LoginStatus status=new LoginStatus();
        boolean loggedIn=status.isLogin();
        assertFalse(loggedIn);
    }



}
