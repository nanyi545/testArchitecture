package com.finance.hechuang.datalayer.cache.imageCache;

import android.content.Context;
import android.graphics.Bitmap;

import com.finance.hechuang.datalayer.cache.Cache;


/**
 * Created by Administrator on 16-3-23.
 */
public class ImageDiskCache implements Cache<String,Bitmap> {


    private long maxSize=8*1024*1024L;  //in bytes

    private DiskLruImageCache cache;

    public ImageDiskCache(Context context){
        cache=new DiskLruImageCache(context,maxSize);
    }


    @Override
    public Bitmap get(String key) {
        String temp_key=key.replace(".","_");  // "." can bot be contained in the key
        return cache.getBitmap(temp_key);
    }

    @Override
    public Bitmap getLast() {
        return null;
    }

    @Override
    public boolean isFresh() {
        return false;
    }

    @Override
    public void put(String key, Bitmap obj) {
        String temp_key=key.replace(".","_");
        cache.put(temp_key, obj);
    }

    @Override
    public boolean isCached(String key) {
        String temp_key=key.replace(".","_");
        return cache.containsKey(temp_key);
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void evictAll() {

    }
}
