package com.finance.hechuang.datalayer.interactors.noUI;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;

import rx.Observable;

/**
 * Created by Administrator on 16-5-21.
 */
public class LoginUseCaseBcgound extends BcgroundUseCase<UserLogin> {


    private final IStoreLogin loginStore;
    private UserLogin userLogin;

    public LoginUseCaseBcgound(ThreadExecutor threadExecutor, IStoreLogin loginStore, UserLogin userLogin) {
        super(threadExecutor);
        this.loginStore=loginStore;
        this.userLogin = userLogin;
    }


    @Override
    protected Observable buildUseCaseObservable(UserLogin userLogin) {
        if(userLogin !=null) this.userLogin = userLogin;
        return loginStore.getLoginObs(this.userLogin);
    }




}
