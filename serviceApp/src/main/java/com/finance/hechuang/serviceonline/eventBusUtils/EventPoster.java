package com.finance.hechuang.serviceonline.eventBusUtils;

import android.support.annotation.WorkerThread;

import com.finance.hechuang.serviceonline.eventBusUtils.events.LoginFailEvent;
import com.finance.hechuang.serviceonline.eventBusUtils.events.NoInternetEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 16-5-21.
 */
public class EventPoster {


    static EventPoster me;
    private EventPoster(){
    }

    public static EventPoster getInstance(){
        if(me==null){
            me=new EventPoster();
        }
        return me;
    }


    @WorkerThread  //  --> does this work?
    public void postNoInternet(long delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new NoInternetEvent());
    }

    public void postLoginFail(long delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().post(new LoginFailEvent());
    }


}
