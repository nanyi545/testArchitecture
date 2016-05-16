package com.finance.hechuang.datalayer.net.implementations;

import android.util.Log;

import com.finance.hechuang.core.entities.User;
import com.finance.hechuang.datalayer.net.Ilogin;

/**
 * Created by Administrator on 16-5-16.
 */
public class FakeLoginPageImp implements Ilogin {


    private User user1=new User("aaa","1234321");
    private User user2=new User("aaaa","1234321");


    @Override
    public boolean doLogin(User user) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("CCC",""+(user.equals(user1))+"  --"+user.equals(user2));
        return user.equals(user1)||user.equals(user2);
    }



}
