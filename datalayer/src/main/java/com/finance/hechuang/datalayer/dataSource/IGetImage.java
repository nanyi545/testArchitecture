package com.finance.hechuang.datalayer.dataSource;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Administrator on 16-5-7.
 */
public interface IGetImage {


    Bitmap getImage(String url);

    List<Bitmap> getImages(int imageGroupID);


}
