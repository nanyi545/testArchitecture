package com.finance.hechuang.serviceonline.logIn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.finance.hechuang.core.entities.User;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageImp;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageSource;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.LoginDataStoreImp;
import com.finance.hechuang.datalayer.interactors.LoginUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.serviceonline.R;
import com.finance.hechuang.serviceonline.ServiceApp;

import rx.Subscriber;

public class LoginActivity extends AppCompatActivity {


    Context me;

    public static void start(Context c){
        Intent i=new Intent(c,LoginActivity.class);
        c.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        me=this;


        ServiceApp app=ServiceApp.getInstance();
        LoginPageSource source=new LoginPageImp();
        IStoreLogin loginStore=new LoginDataStoreImp(me,source);
        User thisUser=new User("abbbaa","1234321");

        UseCase<User> login=new LoginUseCase(app.getWorkerThreadPool(),app.getUiThread(),loginStore,thisUser);


        login.execute(thisUser, new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean yn) {
                if (yn) Toast.makeText(me,"登陆成功",Toast.LENGTH_LONG).show();
                else Toast.makeText(me,"登陆失败",Toast.LENGTH_LONG).show();
            }
        });


    }




}
