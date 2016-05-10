package com.finance.hechuang.serviceonline.RVtest1.presenter;

import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.entities.ViewItemGroup;
import com.finance.hechuang.datalayer.interactors.GetViewItemUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;
import com.finance.hechuang.serviceonline.RVtest1.view.ViewItems;

/**
 * Created by Administrator on 16-5-8.
 */
public class MainPagePresenterIML implements MainPagePresenter{

    private ViewItems viewItems;

    private UseCase getViewItemsUseCase;
    private UseCase getImageUseCase;


    public MainPagePresenterIML(UseCase getImageUseCase, UseCase getViewItemsUseCase) {
        this.getImageUseCase = getImageUseCase;
        this.getViewItemsUseCase = getViewItemsUseCase;
    }

    public MainPagePresenterIML(UseCase getImageUseCase, UseCase getViewItemsUseCase, ViewItems viewItems) {
        this.getImageUseCase = getImageUseCase;
        this.getViewItemsUseCase = getViewItemsUseCase;
        this.viewItems = viewItems;
    }


    public void setView(ViewItems viewItems){
        this.viewItems=viewItems;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getImageUseCase.unsubscribe();
        this.getViewItemsUseCase.unsubscribe();
        this.viewItems=null;
    }


    @Override
    public void onItemClicked(ViewItem item) {

    }

    @Override
    public void showGroups(int groupId) {
        GetViewItemUseCase useCase=(GetViewItemUseCase)getViewItemsUseCase;
        useCase.resetGroupID(groupId);
        useCase.execute(new ItemGroupSubscriber());
    }



    private final class ItemGroupSubscriber extends DefaultSubscriber<ViewItemGroup> {

        @Override public void onCompleted() {
//            UserListPresenter.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
//            UserListPresenter.this.hideViewLoading();
//            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
//            UserListPresenter.this.showViewRetry();
        }

        @Override public void onNext(ViewItemGroup group) {
            viewItems.renderGroup(group.groupId,group.items);
        }

    }










}
