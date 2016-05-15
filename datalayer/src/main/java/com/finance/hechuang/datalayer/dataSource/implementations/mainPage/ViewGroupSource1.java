package com.finance.hechuang.datalayer.dataSource.implementations.mainPage;

import android.content.Context;

import com.finance.hechuang.datalayer.R;
import com.finance.hechuang.datalayer.dataSource.IGetViewGroup;
import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.net.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-8.
 */
public class ViewGroupSource1 implements IGetViewGroup {

    ImageDownloader imageDownloader;

    Context context;

    public ViewGroupSource1(ImageDownloader imageDownloader){
        this.imageDownloader=imageDownloader;
    }

    public ViewGroupSource1(ImageDownloader imageDownloader,Context c){
        this.imageDownloader=imageDownloader;
        this.context=c;
    }


    @Override
    public List<ViewItem> getViewItems(int itemGroupId) {
        List<ViewItem> list=new ArrayList<ViewItem>();
        switch (itemGroupId){
            case IGetViewGroup.MAINPAGE_GROUP1:
                ViewItem item1=new ViewItem("保洁服务","--",context.getString(R.string.iconURL1));item1.setImage(imageDownloader.getImage("url1"));
                ViewItem item2=new ViewItem("家电清洗","--",context.getString(R.string.iconURL2));item2.setImage(imageDownloader.getImage("url1"));
                ViewItem item3=new ViewItem("家具保养","--",context.getString(R.string.iconURL3));item3.setImage(imageDownloader.getImage("url1"));
                ViewItem item4=new ViewItem("企业服务","--",context.getString(R.string.iconURL4));item4.setImage(imageDownloader.getImage("url1"));
                ViewItem item5=new ViewItem("月嫂","--",context.getString(R.string.iconURL5));item5.setImage(imageDownloader.getImage("url1"));
                ViewItem item6=new ViewItem("深度除瞒","--",context.getString(R.string.iconURL6));item6.setImage(imageDownloader.getImage("url1"));
                ViewItem item7=new ViewItem("除甲醛","--",context.getString(R.string.iconURL7));item7.setImage(imageDownloader.getImage("url1"));
                ViewItem item8=new ViewItem("跟多服务","--",context.getString(R.string.iconURL8));item8.setImage(imageDownloader.getImage("url1"));
                list.add(item1);list.add(item2);list.add(item3);list.add(item4);list.add(item5);list.add(item6);list.add(item7);list.add(item8);

                ViewItem item21=new ViewItem("日常保洁","2小时起，会员享优惠",context.getString(R.string.iconURL9),1,2);item21.setImage(imageDownloader.getImage("url1"));
                ViewItem item22=new ViewItem("擦玻璃","洁净明亮如初",context.getString(R.string.iconURL10));item22.setImage(imageDownloader.getImage("url1"));
                ViewItem item23=new ViewItem("深度保洁","家里焕然一新",context.getString(R.string.iconURL11));item23.setImage(imageDownloader.getImage("url1"));
                list.add(item21);list.add(item22);list.add(item23);

                ViewItem item31=new ViewItem("家电清洗套餐","关爱上线",context.getString(R.string.iconURL12));item31.setImage(imageDownloader.getImage("url1"));
                list.add(item31);

                ViewItem item41=new ViewItem("油烟机清洗","深度去除油污",context.getString(R.string.iconURL13));item41.setImage(imageDownloader.getImage("url1"));
                ViewItem item42=new ViewItem("新居开荒","乔迁新居首选",context.getString(R.string.iconURL14));item42.setImage(imageDownloader.getImage("url1"));
                ViewItem item43=new ViewItem("洗衣机清洗","洗衣机跟要被清洗",context.getString(R.string.iconURL15));item43.setImage(imageDownloader.getImage("url1"));
                ViewItem item44=new ViewItem("冰箱清洗","除味除冰清洁消毒",context.getString(R.string.iconURL16));item44.setImage(imageDownloader.getImage("url1"));
                list.add(item41);list.add(item42);list.add(item43);list.add(item44);


                break;
            case IGetViewGroup.MAINPAGE_GROUP2:
                ViewItem item21x=new ViewItem("日常保洁","2小时起，会员享优惠","url1",1,2);item21x.setImage(imageDownloader.getImage("url1"));
                ViewItem item22x=new ViewItem("擦玻璃","洁净明亮如初","url1");item22x.setImage(imageDownloader.getImage("url1"));
                ViewItem item23x=new ViewItem("深度保洁","家里焕然一新","url1");item23x.setImage(imageDownloader.getImage("url1"));
                list.add(item21x);list.add(item22x);list.add(item23x);
                break;
            case IGetViewGroup.MAINPAGE_GROUP3:
                ViewItem item31x=new ViewItem("家电清洗套餐","关爱上线","url1");item31x.setImage(imageDownloader.getImage("url1"));
                list.add(item31x);
                break;
            case IGetViewGroup.MAINPAGE_GROUP4:
                ViewItem item41x=new ViewItem("油烟机清洗","深度去除油污","url1");item41x.setImage(imageDownloader.getImage("url1"));
                ViewItem item42x=new ViewItem("新居开荒","乔迁新居首选","url1");item42x.setImage(imageDownloader.getImage("url1"));
                ViewItem item43x=new ViewItem("洗衣机清洗","洗衣机跟要被清洗","url1");item43x.setImage(imageDownloader.getImage("url1"));
                ViewItem item44x=new ViewItem("冰箱清洗","除味除冰清洁消毒","url1");item44x.setImage(imageDownloader.getImage("url1"));
                list.add(item41x);list.add(item42x);list.add(item43x);list.add(item44x);
                break;
            default:break;
        }

        return list;
    }


}
