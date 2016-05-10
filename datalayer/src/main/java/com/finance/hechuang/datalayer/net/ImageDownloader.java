package com.finance.hechuang.datalayer.net;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by nanyi545 on 16-5-8.
 *
 * contract for downloading images from the server
 */
public interface ImageDownloader {

    Bitmap getImage(String url);

    List<Bitmap> getImages(int imageGroupID);

}
