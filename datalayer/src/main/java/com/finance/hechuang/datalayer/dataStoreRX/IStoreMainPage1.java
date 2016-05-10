package com.finance.hechuang.datalayer.dataStoreRX;

import android.graphics.Bitmap;

import com.finance.hechuang.datalayer.entities.ViewItemGroup;

import rx.Observable;

/**
 * Created by nanyi545 on 16-5-8.\
 *
 * DataStore to provide data(wrapped in observables) to
 *
 *
 */
public interface IStoreMainPage1 {


    Observable<ViewItemGroup> getViewItems(int viewItemGroupId);

    Observable<Bitmap> getImage(String imageURL);

}
