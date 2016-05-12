package com.finance.hechuang.serviceonline.RVtest1.view;

import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.serviceonline.views.LoadDataView;

import java.util.List;

/**
 * Created by Administrator on 16-5-8.
 */
public interface ViewItems extends LoadDataView{

    /**
     * Render a group of ViewItems in the UI.  (provide data to the adapter)
     *
     * the groups are defined at :
     * {@link com.finance.hechuang.datalayer.dataSource.IGetViewGroup}
     *
     */
    void renderGroup(int groupId, List<ViewItem> list);


    /**
     * action upon clicking a ViewItem
     * @param groupId
     * @param item
     */
    void clickViewItem(int groupId, ViewItem item);

//    /**
//     * load an bitmap from a URL
//     * @param url
//     */
//    void loadImage(String url);

}
