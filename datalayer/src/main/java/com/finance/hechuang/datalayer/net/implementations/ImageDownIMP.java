package com.finance.hechuang.datalayer.net.implementations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.finance.hechuang.datalayer.R;
import com.finance.hechuang.datalayer.net.ImageDownloader;

import java.util.List;

/**
 * Created by nanyi545 on 16-5-8.
 *
 * this is a mock class to mock image downloading
 */
public class ImageDownIMP implements ImageDownloader {


    Context activityContext;

    public ImageDownIMP(Context context){
        this.activityContext =context;
    }


    @Override
    public Bitmap getImage(String url) {  // return the same image from what-ever resource
        Resources res= activityContext.getResources();   // need to use activity context / not application context
        Bitmap bmp= BitmapFactory.decodeResource(res, R.drawable.cat1);
        return bmp;
    }

    @Override
    public List<Bitmap> getImages(int imageGroupID) {
        return null;
    }


}
