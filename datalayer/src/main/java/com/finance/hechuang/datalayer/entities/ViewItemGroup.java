package com.finance.hechuang.datalayer.entities;

import java.util.List;

/**
 * Created by nanyi545 on 16-5-8.
 *
 * class to hold a group (in form of a List) of ViewItems
 *
 */
public final class ViewItemGroup{

    public int groupId;
    public List<ViewItem> items;
    public ViewItemGroup(int groupId,List<ViewItem> items){
        this.groupId=groupId;
        this.items=items;
    }

    @Override
    public String toString() {
        return ("groupId:"+groupId+" "+items.toString());
    }
}

