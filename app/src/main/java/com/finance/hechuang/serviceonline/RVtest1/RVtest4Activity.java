package com.finance.hechuang.serviceonline.RVtest1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.MainPageDataStore1;
import com.finance.hechuang.datalayer.entities.ViewItem;
import com.finance.hechuang.datalayer.interactors.GetImageUseCase;
import com.finance.hechuang.datalayer.interactors.GetViewItemUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.serviceonline.R;
import com.finance.hechuang.serviceonline.RVtest1.presenter.MainPagePresenter;
import com.finance.hechuang.serviceonline.RVtest1.presenter.MainPagePresenterIML4;
import com.finance.hechuang.serviceonline.RVtest1.utils.RecyclerListAdapter;
import com.finance.hechuang.serviceonline.RVtest1.view.ViewItems;
import com.finance.hechuang.serviceonline.ServiceApp;

import java.util.List;

public class RVtest4Activity extends AppCompatActivity {

    public static void start(Context context){
        Intent i1=new Intent(context,RVtest4Activity.class);
        context.startActivity(i1);
    }



    ViewItems mView;
    MainPagePresenter presenter;
    UseCase<Integer> getViewItemUseCase;
    UseCase<String> getImageUseCase;
    ServiceApp app=ServiceApp.getInstance();
    IStoreMainPage1 dataStore1=new MainPageDataStore1(this);

    private RecyclerView mRecyclerView;
    private RecyclerListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtest4);

        adapter = new RecyclerListAdapter(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);


        mView=new ViewItems(){
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

            @Override
            public void renderGroup(int groupId, List<ViewItem> list) {
                adapter.updateAdapter(list);
            }

            @Override
            public void clickViewItem(int groupId, ViewItem item) {
                Log.i("AAA","groupId:"+groupId+"  "+item.toString());
            }

        };


        adapter.setAdapterClickListener(new RecyclerListAdapter.OnAdapterClick() {
            @Override
            public void onItemClick(ViewItem item, int number) {
                mView.clickViewItem(1,item);
            }

            @Override
            public void onItemLongClick(ViewItem item, int number) {

            }
        });


        getViewItemUseCase=new GetViewItemUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,2);
        getImageUseCase=new GetImageUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,"---");
        presenter=new MainPagePresenterIML4(getImageUseCase,getViewItemUseCase,mView);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.showGroups(1);
    }


}
