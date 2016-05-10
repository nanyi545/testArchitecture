package com.finance.hechuang.serviceonline.RVtest1.view;

import android.content.Context;

import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.serviceonline.utils.logCat.LogTool;

import java.util.List;

/**
 * Created by Administrator on 16-5-8.
 */
public class LogCatPresenter implements ViewItems {


    @Override
    public void renderGroup(int groupId, List<ViewItem> list) {
        LogTool.showLog1("group id:"+groupId+"   "+list.toString());
    }

    @Override
    public void clickViewItem(int groupId, ViewItem item) {
        LogTool.showLog1("group id:"+groupId+"   "+item.toString());
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }



}
