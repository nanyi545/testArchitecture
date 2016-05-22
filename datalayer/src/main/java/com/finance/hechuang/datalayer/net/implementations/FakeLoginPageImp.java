package com.finance.hechuang.datalayer.net.implementations;

import android.util.Log;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.net.Ilogin;

/**
 * Created by Administrator on 16-5-16.
 */
public class FakeLoginPageImp implements Ilogin {


    private UserLogin userLogin1 =new UserLogin("aaa","1234321");
//    private UserLogin userLogin1 =new UserLogin("bbb","1234321");
    private UserLogin userLogin2 =new UserLogin("aaaa","1234321");


    @Override
    public boolean doLogin(UserLogin userLogin) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("CCC",""+(userLogin.equals(userLogin1))+"  --"+ userLogin.equals(userLogin2));
        return userLogin.equals(userLogin1)||userLogin.equals(userLogin2);
    }



}
