package com.finance.hechuang.serviceonline.RVtest1.presenter;

import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.serviceonline.presenter.Presenter;

/**
 * Created by Administrator on 16-5-8.
 */
public interface MainPagePresenter extends Presenter {

    // action upon click of an item
    void onItemClicked(ViewItem item);


    // to show a group of items (by calling ViewItems.renderGroup(..))
    void showGroups(int groupId);


}
