package com.finance.hechuang.datalayer.interactors;

import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.executors.PostExecutionThread;
import com.finance.hechuang.datalayer.executors.ThreadExecutor;

import rx.Observable;

/**
 * Created by Administrator on 16-5-8.
 */
public class GetViewItemUseCase extends UseCase<Integer>{

    private final IStoreMainPage1 dataStore1;
    private int groupID;

    public void resetGroupID(int groupID){
        this.groupID=groupID;
    }


    public GetViewItemUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,IStoreMainPage1 dataStore1,int groupID) {
        super(threadExecutor, postExecutionThread);
        this.dataStore1=dataStore1;
        this.groupID=groupID;
    }

    @Override
    protected Observable buildUseCaseObservable(Integer groupID) {
        this.groupID=groupID;
        return dataStore1.getViewItems(groupID);
    }



}
