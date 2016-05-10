package com.finance.hechuang.datalayer.dataSource;

import com.finance.hechuang.datalayer.entities.ViewItem;

import java.util.List;

/**
 * Created by Administrator on 16-5-8.
 *
 * there are 4 groups of ViewItems that is needed on the UI
 *
 */
public interface IGetViewGroup {

    int MAINPAGE_GROUP1=1;
    int MAINPAGE_GROUP2=2;
    int MAINPAGE_GROUP3=3;
    int MAINPAGE_GROUP4=4;


    List<ViewItem> getViewItems(int itemGroupId);

}
