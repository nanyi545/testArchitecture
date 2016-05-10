package com.finance.hechuang.datalayer.interactors;

import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.executors.PostExecutionThread;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;

import rx.Observable;

/**
 * Created by Administrator on 16-5-8.
 */
public class GetImageUseCase extends UseCase{

    private final IStoreMainPage1 dataStore1;
    private final String url;


    public GetImageUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, IStoreMainPage1 dataStore1, String url) {
        super(threadExecutor, postExecutionThread);
        this.dataStore1=dataStore1;
        this.url=url;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return dataStore1.getImage(url);
    }


}
