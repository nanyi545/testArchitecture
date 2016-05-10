package com.finance.hechuang.datalayer.entities;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 16-5-8.
 */
public class ViewItem {

    public final String mainText;
    public final String introduction;
    public final String imagaURL;
    public Bitmap image;

    public int hWeight=1;
    public int wWeight=1;


    public ViewItem(String str1,String str2,String str3){
        mainText=str1;
        introduction=str2;
        imagaURL=str3;
    }

    public ViewItem(String str1,String str2,String str3,int w,int h){
        mainText=str1;
        introduction=str2;
        imagaURL=str3;
        hWeight=h;
        wWeight=w;
    }

    public void setImage(Bitmap image){
        this.image=image;
    }



    @Override
    public String toString() {
        return (mainText+"..."+introduction+"..."+imagaURL+"..."+hWeight+"..."+wWeight);
    }




}
