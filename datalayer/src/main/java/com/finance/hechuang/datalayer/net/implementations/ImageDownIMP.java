package com.finance.hechuang.datalayer.net.implementations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.finance.hechuang.datalayer.R;
import com.finance.hechuang.datalayer.logs.LogUtil;
import com.finance.hechuang.datalayer.net.ImageDownloader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    public Bitmap getImage(String url) {  // return  image from a valid URL, if not valid, return a default image

        LogUtil.LogThreadInfo("getImage in:" + Thread.currentThread().getName());

        Bitmap bitmap=null;
        URL url1 = null;
        try {
            url1 = new URL(url);
            HttpURLConnection htc = (HttpURLConnection) url1.openConnection();
            InputStream is = new BufferedInputStream(htc.getInputStream());
            bitmap = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Resources res = activityContext.getResources();   // need to use activity context / not application context
            bitmap = BitmapFactory.decodeResource(res, R.drawable.cat1);
        } catch (IOException e) {
            e.printStackTrace();
            Resources res = activityContext.getResources();
            bitmap = BitmapFactory.decodeResource(res, R.drawable.cat1);
        }
        return bitmap;
    }

    @Override
    public List<Bitmap> getImages(int imageGroupID) {
        return null;
    }


}
