package com.finance.hechuang.serviceonline;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.dataSource.implementations.mainPage.MainPageIML;
import com.finance.hechuang.datalayer.dataSource.implementations.mainPage.MainPageSource;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.MainPageDataStore1;
import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.interactors.GetViewItemUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;
import com.finance.hechuang.serviceonline.RVtest1.RVtest1Activity;
import com.finance.hechuang.serviceonline.utils.encrypt.EncrypAES;
import com.finance.hechuang.serviceonline.utils.logCat.LogTool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 16-1-10.
 */
public class ActivitTest1 extends ActivityInstrumentationTestCase2<RVtest1Activity>{

    private RVtest1Activity mActivity;

    private ServiceApp app;

    public ActivitTest1() {
        super(RVtest1Activity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        app=(ServiceApp)mActivity.getApplicationContext();
    }


    public void testString() {
        MainPageSource s1=new MainPageIML(mActivity);

        LogTool.showLog1(s1.getViewItems(1).toString());
        LogTool.showLog1(s1.getViewItems(2).toString());
        LogTool.showLog1(s1.getViewItems(3).toString());
        LogTool.showLog1(s1.getViewItems(4).toString());
    }

    public void testConnection() {   // use reflection to test private methods
        Log.i("AAA","---------------");
        MainPageDataStore1 store1=new MainPageDataStore1(mActivity);
        try {
            Method m1=store1.getClass().getDeclaredMethod("isThereInternetConnection",(Class[]) null);
            m1.setAccessible(true);
            boolean yn=(Boolean)m1.invoke(store1);
            Log.i("AAA","result:"+yn);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Log.i("AAA","NoSuchMethodException");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Log.i("AAA","InvocationTargetException");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Log.i("AAA","IllegalAccessException");
        }
    }




    //---------------???----------------
    public void testUseCase(){

        ServiceApp app=(ServiceApp)mActivity.getApplication();
        IStoreMainPage1 dataStore1=new MainPageDataStore1(mActivity);

        UseCase getViewItems=new GetViewItemUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,1);


        Subscriber<List<ViewItem>> subs= new DefaultSubscriber<List<ViewItem>>(){
            @Override
            public void onNext(List<ViewItem> list) {
                Log.i("AAA",list.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.i("AAA",Log.getStackTraceString(e));
            }
        };


//        getViewItems.execute(subs);


    }



    public void testAES() {
        String str1="test1";
        String encrypted= EncrypAES.getInstance().encrypt(str1);
        LogTool.showLoginLog1("testAES--"+encrypted);// 93313150647B2FDAD10D628BED91E917
        LogTool.showLoginLog1("testAES--"+EncrypAES.getInstance().decrypt(encrypted));
    }

    public void testReadSP(){
        UserLogin login=app.securePreference.secureGetUser();
//        LogTool.showLoginLog1(login.userId);
        assertEquals("aaa",login.userId);
        assertEquals("1234321",login.pass);
    }

    public void testWriteSP(){
        app.securePreference.secureWriteUser(new UserLogin("aaa","1234321"));
    }

    public void testWriteSP2(){
        app.securePreference.setAutoLogin(true);
    }
    public void testWriteSP3(){
        app.securePreference.setAutoLogin(false);
    }




}
