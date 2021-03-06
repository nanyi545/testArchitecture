package com.finance.hechuang.datalayer.interactors;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.executors.PostExecutionThread;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;

import rx.Observable;

/**
 * Created by Administrator on 16-5-16.
 */
public class LoginUseCase extends UseCase<UserLogin> {

    private final IStoreLogin loginStore;
    private UserLogin userLogin;

    public LoginUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IStoreLogin loginStore, UserLogin userLogin) {
        super(threadExecutor, postExecutionThread);
        this.loginStore=loginStore;
        this.userLogin = userLogin;
    }


    @Override
    protected Observable buildUseCaseObservable(UserLogin userLogin) {
        if(userLogin !=null) this.userLogin = userLogin;
        return loginStore.getLoginObs(this.userLogin);
    }

    
}
