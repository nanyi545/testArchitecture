package com.finance.hechuang.datalayer.interactors;

import com.finance.hechuang.core.entities.User;
import com.finance.hechuang.datalayer.dataStoreRX.IStoreLogin;
import com.finance.hechuang.datalayer.executors.PostExecutionThread;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;

import rx.Observable;

/**
 * Created by Administrator on 16-5-16.
 */
public class LoginUseCase extends UseCase<User> {

    private final IStoreLogin loginStore;
    private User user;

    public LoginUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IStoreLogin loginStore, User user) {
        super(threadExecutor, postExecutionThread);
        this.loginStore=loginStore;
        this.user=user;
    }


    @Override
    protected Observable buildUseCaseObservable(User user) {
        if(user!=null) this.user=user;
        return loginStore.getLoginObs(this.user);
    }

    
}
