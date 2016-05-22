package com.finance.hechuang.datalayer.dataSource.implementations.loginPage;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.net.Ilogin;
import com.finance.hechuang.datalayer.net.implementations.FakeLoginPageImp;

/**
 * Created by Administrator on 16-5-16.
 */
public class LoginPageImp implements LoginPageSource {

    Ilogin login=new FakeLoginPageImp();

    @Override
    public boolean doLogin(UserLogin userLogin) {
        return login.doLogin(userLogin);
    }



}
