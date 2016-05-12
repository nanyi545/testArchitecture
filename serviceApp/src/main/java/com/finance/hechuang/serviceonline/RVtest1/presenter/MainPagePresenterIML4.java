package com.finance.hechuang.serviceonline.RVtest1.presenter;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.entities.ViewItemGroup;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;
import com.finance.hechuang.serviceonline.RVtest1.view.ViewItems;

/**
 * Created by Administrator on 16-5-8.
 */
public class MainPagePresenterIML4 implements MainPagePresenter{

    private ViewItems viewItems;

    private UseCase<Integer> getViewItemsUseCase;
    private UseCase<String> getImageUseCase;


    public MainPagePresenterIML4(UseCase getImageUseCase, UseCase getViewItemsUseCase) {
        this.getImageUseCase = getImageUseCase;
        this.getViewItemsUseCase = getViewItemsUseCase;
    }

    public MainPagePresenterIML4(UseCase getImageUseCase, UseCase getViewItemsUseCase, ViewItems viewItems) {
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
    public void onItemClicked(int groudId,ViewItem item) {
        viewItems.clickViewItem(groudId,item);
    }

    @Override
    public void showGroups(int groupId) {
        getViewItemsUseCase.execute(groupId,new ItemGroupSubscriber());
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



    public void loadImage(String url,ImageView targetIv){
        getImageUseCase.execute(url,new ImageSubscriber(targetIv));
    }


    public final class ImageSubscriber extends DefaultSubscriber<Bitmap> {
        ImageView targetIv;

        public ImageSubscriber(ImageView targetIv){
            this.targetIv=targetIv;
        }

        @Override public void onCompleted() {
//            UserListPresenter.this.hideViewLoading();
        }

        @Override public void onError(Throwable e) {
//            UserListPresenter.this.hideViewLoading();
//            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
//            UserListPresenter.this.showViewRetry();
        }

        @Override public void onNext(Bitmap bitmap) {
            targetIv.setImageBitmap(bitmap);
        }
    }













}
