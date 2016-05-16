package com.finance.hechuang.datalayer.dataStoreRX;

import com.finance.hechuang.core.entities.User;

import rx.Observable;

/**
 * Created by Administrator on 16-5-16.
 */
public interface IStoreLogin {

    Observable<Boolean> getLoginObs(User user);

}
