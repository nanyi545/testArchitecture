package com.finance.hechuang.datalayer.dataStoreRX.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.dataSource.implementations.loginPage.LoginPageSource;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.exceptions.NetworkConnectionException;
import com.finance.hechuang.datalayer.logs.LogUtil;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 16-5-16.
 */
public class LoginDataStoreImp implements IStoreLogin {


    private LoginPageSource source;
    private Context activityContext;

    public LoginDataStoreImp(Context c,LoginPageSource source){
        activityContext=c;
        this.source=source;
    }

    /**
     * Checks if the device has any active internet connection.
     * you can use application-Context
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected = false;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.activityContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return isConnected;
    }



    @Override
    public Observable<Boolean> getLoginObs(final UserLogin userLogin) {
        Observable<Boolean> observable = Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                if (isThereInternetConnection()) {
                    try {
                        subscriber.onNext(source.doLogin(userLogin));
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        e.printStackTrace();
                        subscriber.onError(new NetworkConnectionException());
                    }

                } else {
                    subscriber.onError(new NetworkConnectionException());
                }
                LogUtil.LogThreadInfo("in getLoginObs Call in:" + Thread.currentThread().getName()); // IN rxAndroid---> specified by subscribeOn()
            }
        });
        return observable;

    }



}
