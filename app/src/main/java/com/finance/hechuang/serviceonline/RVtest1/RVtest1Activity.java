package com.finance.hechuang.serviceonline.RVtest1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.finance.hechuang.datalayer.cache.imageCache.DiskLruImageCache;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.MainPageDataStore1;
import com.finance.hechuang.datalayer.entities.ViewItemGroup;
import com.finance.hechuang.datalayer.interactors.GetImageUseCase;
import com.finance.hechuang.datalayer.interactors.GetViewItemUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;
import com.finance.hechuang.serviceonline.R;
import com.finance.hechuang.serviceonline.ServiceApp;

import java.io.File;

import rx.Subscriber;

public class RVtest1Activity extends AppCompatActivity {


    public static void start(Context context){
        Intent i1=new Intent(context,RVtest1Activity.class);
        context.startActivity(i1);
    }


    DiskLruImageCache cache;

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cache=new DiskLruImageCache(this,1234134);
        Log.i("AAA",cache.getCacheFolder().getAbsolutePath());
        File[] files=cache.getCacheFolder().listFiles();
        for (int ii=0;ii<files.length;ii++)
        Log.i("AAA",files[ii].getAbsolutePath());



        setContentView(R.layout.activity_rvtest1);


        iv= (ImageView) findViewById(R.id.testIv);

        ServiceApp app=ServiceApp.getInstance();
        IStoreMainPage1 dataStore1=new MainPageDataStore1(this);

        UseCase getImages=new GetImageUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,"URLURL");
        UseCase getViewItems=new GetViewItemUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,2);


//        Subscriber<Bitmap> subs= new DefaultSubscriber<Bitmap>(){
//            @Override
//            public void onNext(Bitmap bitmap) {
//                iv.setImageBitmap(bitmap);
//            }
//            @Override
//            public void onError(Throwable e) {
//                Log.i("AAA",Log.getStackTraceString(e));
//            }
//        };
//        getImages.execute(subs);


        Subscriber<ViewItemGroup> subs2= new DefaultSubscriber<ViewItemGroup>(){
            @Override
            public void onNext(ViewItemGroup group) {
                Log.i("AAA",group.toString());
                iv.setImageBitmap(group.items.get(0).image);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("AAA",Log.getStackTraceString(e));
            }
        };

        getViewItems.execute(subs2);


    }





}
