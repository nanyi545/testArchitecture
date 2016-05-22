package com.finance.hechuang.serviceonline.utils.logCat;

import android.util.Log;

/**
 * Created by Administrator on 16-5-8.
 */
public class LogTool {

    public static final boolean SHOW_LOG1=true;
    public static final String LOG1_STR="AAA";
    public static final void showLog1(String str){
        if (SHOW_LOG1) Log.i(LOG1_STR,str);
    }


    public static final boolean SHOW_LOGIN_LOG1=true;
    public static final String LOGIN_LOG1="login";
    public static final void showLoginLog1(String str){
        if (SHOW_LOGIN_LOG1) Log.i(LOGIN_LOG1,str);
    }



}
