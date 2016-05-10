package com.finance.hechuang.datalayer.dataStoreRX.implementations;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.finance.hechuang.datalayer.dataSource.implementations.mainPage.MainPageIML;
import com.finance.hechuang.datalayer.dataSource.implementations.mainPage.MainPageSource;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.entities.ViewItemGroup;
import com.finance.hechuang.datalayer.exceptions.NetworkConnectionException;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 16-5-8.
 */
public class MainPageDataStore1 implements IStoreMainPage1 {


    Context activityContext;
    MainPageSource source;


    public MainPageDataStore1(Context activityContext) {
        this.activityContext = activityContext;
        source = new MainPageIML(this.activityContext);  // pass in mock data source
    }

    public MainPageDataStore1(Context activityContext, MainPageSource realSource) {
        this.activityContext = activityContext;
        source = realSource;  // pass in real data source
    }


    /**
     * Checks if the device has any active internet connection.------> not here
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected = true;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.activityContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());
        return isConnected;
    }


    @Override
    public Observable<ViewItemGroup> getViewItems(final int viewItemGroupId) {
        Observable<ViewItemGroup> observable = Observable.create(new Observable.OnSubscribe<ViewItemGroup>() {
            @Override
            public void call(Subscriber<? super ViewItemGroup> subscriber) {
                if (isThereInternetConnection()) {

                    try {
                        List<ViewItem> viewItems = source.getViewItems(viewItemGroupId);
                        subscriber.onNext(new ViewItemGroup(viewItemGroupId,viewItems));
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        e.printStackTrace();
                        subscriber.onError(new NetworkConnectionException());
                    }

                } else {
                    subscriber.onError(new NetworkConnectionException());
                }
                Log.i("AAA", "in observable Call in thread:" + Thread.currentThread().getName());
            }
        });
        Log.i("AAA", "getEntriesObs in thread:" + Thread.currentThread().getName());
        return observable;

    }

    @Override
    public Observable<Bitmap> getImage(final String imageURL) {
        Observable<Bitmap> obser = Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                if (isThereInternetConnection()) {
                    try {
                        subscriber.onNext(source.getImage(imageURL));
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        e.printStackTrace();
                        subscriber.onError(new NetworkConnectionException());
                    }
                } else {
                    subscriber.onError(new NetworkConnectionException());
                }
            }
        });
        return obser;
    }




}
