package com.finance.hechuang.serviceonline;

import android.app.Application;

import com.finance.hechuang.datalayer.executors.JobExecutor;
import com.finance.hechuang.datalayer.executors.PostExecutionThread;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;
import com.finance.hechuang.datalayer.executors.UIThread;

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


    @Override
    public void onCreate() {
        super.onCreate();
        me=this;

        uiThread=new UIThread();
        workerThreadPool=new JobExecutor();

    }




}
