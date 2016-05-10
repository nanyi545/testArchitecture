package com.finance.hechuang.datalayer.dataSource.implementations.mainPage;

import android.content.Context;
import android.graphics.Bitmap;

import com.finance.hechuang.datalayer.dataSource.IGetViewGroup;
import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.net.ImageDownloader;
import com.finance.hechuang.datalayer.net.implementations.ImageDownIMP;

import java.util.List;

/**
 * Created by Administrator on 16-5-8.
 */
public class MainPageIML implements MainPageSource {

    Context activityContext;
    ImageDownloader imageDownloader;
    IGetViewGroup viewItemSource;

    public MainPageIML(Context context){
        this.activityContext =context;
        imageDownloader=new ImageDownIMP(this.activityContext);
        viewItemSource=new ViewGroupSource1(imageDownloader);
    }


    @Override
    public Bitmap getImage(String url) {
        return imageDownloader.getImage(url);
    }

    @Override
    public List<Bitmap> getImages(int imageGroupID) {
        return imageDownloader.getImages(imageGroupID);
    }

    @Override
    public List<ViewItem> getViewItems(int itemGroupId) {
        return viewItemSource.getViewItems(itemGroupId);
    }
}
