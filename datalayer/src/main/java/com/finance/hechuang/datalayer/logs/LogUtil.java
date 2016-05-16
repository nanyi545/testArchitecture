package com.finance.hechuang.datalayer.logs;

import android.util.Log;

/**
 * Created by Administrator on 16-5-16.
 */
public class LogUtil {


    // ---- log showing thread information ---
    private static final boolean LOG_THREAD_INFO=true;
    private static final String LOG_THREAD_KEY="thread_key";
    public static void LogThreadInfo(String str){
        if(LOG_THREAD_INFO) Log.i(LOG_THREAD_KEY,str);
    }






}
