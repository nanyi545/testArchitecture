package com.finance.hechuang.serviceonline.logIn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageImp;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageSource;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.LoginDataStoreImp;
import com.finance.hechuang.datalayer.interactors.LoginUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.serviceonline.R;
import com.finance.hechuang.serviceonline.ServiceApp;
import com.finance.hechuang.serviceonline.utils.logCat.LogTool;

public class LoginActivity extends AppCompatActivity implements LogInContract.LogInView {


    Context me;

    public static void start(Context c){
        Intent i=new Intent(c,LoginActivity.class);
        c.startActivity(i);
    }


    public void doLogin(View v){
        loginP.doLogin();
    }


    LogInContract.LogInPresentor loginP;


    EditText userET;
    EditText userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userET= (EditText) findViewById(R.id.account_ev);
        userPass= (EditText) findViewById(R.id.pass_ev);


        me=this;


        ServiceApp app=ServiceApp.getInstance();
        LoginPageSource source=new LoginPageImp();
        IStoreLogin loginStore=new LoginDataStoreImp(me,source);

        UserLogin thisUserLogin =new UserLogin("abbbaa","1234321");
        UseCase<UserLogin> login=new LoginUseCase(app.getWorkerThreadPool(),app.getUiThread(),loginStore, thisUserLogin);
        loginP=new LoginPresenterImp(login,this);


//        login.execute(thisUserLogin, new Subscriber<Boolean>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Boolean yn) {
//                if (yn) Toast.makeText(me,"登陆成功",Toast.LENGTH_LONG).show();
//                else Toast.makeText(me,"登陆失败",Toast.LENGTH_LONG).show();
//            }
//        });


    }


    @Override
    public void logInFail() {
        LogTool.showLoginLog1("---fail---");
        Toast.makeText(me,"登陆失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void logInSuccess() {
        LogTool.showLoginLog1("---success---");
        Toast.makeText(me,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public UserLogin getUser() {
        LogTool.showLoginLog1(userET.getText().toString()+"---"+userPass.getText().toString());
        return new UserLogin(userET.getText().toString(),userPass.getText().toString());
    }

    @Override
    public void startLogin() {

    }

    @Override
    public void registerNewAccount() {

    }

    @Override
    public void showPass() {

    }

    @Override
    public void hidePass() {

    }

    @Override
    public void forgetPass() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }
}
