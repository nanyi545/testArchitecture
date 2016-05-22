package com.finance.hechuang.serviceonline;

import android.app.Application;

import com.finance.hechuang.core.entities.LoginStatus;
import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageImp;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageSource;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.LoginDataStoreImp;
import com.finance.hechuang.datalayer.exceptions.NetworkConnectionException;
import com.finance.hechuang.datalayer.executors.JobExecutor;
import com.finance.hechuang.datalayer.executors.PostExecutionThread;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;
import com.finance.hechuang.datalayer.executors.UIThread;
import com.finance.hechuang.datalayer.interactors.noUI.LoginUseCaseBcgound;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;
import com.finance.hechuang.serviceonline.eventBusUtils.EventPoster;
import com.finance.hechuang.serviceonline.utils.logCat.LogTool;
import com.finance.hechuang.serviceonline.utils.preference.SecurePreference;

import rx.Subscriber;

/**
 * Created by Administrator on 16-5-8.
 */
public class ServiceApp extends Application {

    private static ServiceApp me;

    public static ServiceApp getInstance(){
        return me;
    }


    static PostExecutionThread uiThread;
    public PostExecutionThread getUiThread(){return uiThread;}

    static ThreadExecutor workerThreadPool;
    public ThreadExecutor getWorkerThreadPool(){return workerThreadPool;}


    //----login status -----
    private boolean autoLogin=false;
    public SecurePreference securePreference;
    public LoginStatus status=new LoginStatus();  // keep login status
    private UserLogin temp;

    LoginPageSource source=new LoginPageImp();
    IStoreLogin loginStore;
    LoginUseCaseBcgound login;


    Subscriber<Boolean> loginSubs=new DefaultSubscriber<Boolean>(){
        @Override
        public void onError(Throwable e) {
//            LogTool.showLoginLog1("onerror  --"+Thread.currentThread().getName());
//            LogUtil.LogThreadInfo("onerror");
//            LogTool.showLoginLog1(Log.getStackTraceString(e));
            if (e instanceof NetworkConnectionException){  //
                LogTool.showLoginLog1("NetworkConnectionException  --");
                EventPoster.getInstance().postNoInternet(200);
            }
        }

        @Override
        public void onNext(Boolean aBoolean) {  // returns if login successful
            autoLogin=aBoolean;
            securePreference.setAutoLogin(autoLogin);
            if(autoLogin) {   // login successful
                UserLogin l = null;
                try {
                    l = (UserLogin) temp.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                status.updateLogin(l);
            } else{  // login failed
                EventPoster.getInstance().postLoginFail(200);
            }
            LogTool.showLoginLog1("autoLogin"+autoLogin+"  --"+Thread.currentThread().getName());

        }

        @Override
        public void onCompleted() {
            LogTool.showLoginLog1("onCompleted  --"+Thread.currentThread().getName());
        }
    };




    @Override
    public void onCreate() {
        super.onCreate();
        me=this;

        // specify UI thread and worker threadpool
        uiThread=new UIThread();
        workerThreadPool=new JobExecutor();

        // ---secure preference ---> write SP with AES encoding --
        securePreference=new SecurePreference(this);
        autoLogin=securePreference.getAutoLogin();

        //--- login use-case ---
        loginStore=new LoginDataStoreImp(me,source);
        login=new LoginUseCaseBcgound(workerThreadPool,loginStore,status.getLogin());



        if(autoLogin){
            LogTool.showLoginLog1("autoLogin:"+autoLogin);
            temp=securePreference.secureGetUser();
            login.execute(temp,loginSubs);
        }else{
            LogTool.showLoginLog1("no autoLogin:"+Thread.currentThread().getName());
            LogTool.showLoginLog1("no autoLogin:"+status.isLogin());
        }






    }







}
