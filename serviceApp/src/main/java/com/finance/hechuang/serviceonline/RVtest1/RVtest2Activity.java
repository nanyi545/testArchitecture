package com.finance.hechuang.serviceonline.RVtest1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.finance.hechuang.datalayer.dataStoreRX.IStoreMainPage1;
import com.finance.hechuang.datalayer.dataStoreRX.implementations.MainPageDataStore1;
import com.finance.hechuang.datalayer.interactors.GetImageUseCase;
import com.finance.hechuang.datalayer.interactors.GetViewItemUseCase;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.serviceonline.R;
import com.finance.hechuang.serviceonline.RVtest1.presenter.MainPagePresenter;
import com.finance.hechuang.serviceonline.RVtest1.presenter.MainPagePresenterIML;
import com.finance.hechuang.serviceonline.RVtest1.view.LogCatView;
import com.finance.hechuang.serviceonline.RVtest1.view.ViewItems;
import com.finance.hechuang.serviceonline.ServiceApp;

public class RVtest2Activity extends AppCompatActivity {

    public static void start(Context context){
        Intent i1=new Intent(context,RVtest2Activity.class);
        context.startActivity(i1);
    }


    MainPagePresenter presenter;
    ViewItems view=new LogCatView();
    UseCase getViewItemUseCase;
    UseCase getImageUseCase;
    ServiceApp app=ServiceApp.getInstance();
    IStoreMainPage1 dataStore1=new MainPageDataStore1(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtest2);
        getViewItemUseCase=new GetViewItemUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,2);
        getImageUseCase=new GetImageUseCase(app.getWorkerThreadPool(),app.getUiThread(),dataStore1,"---");
        presenter=new MainPagePresenterIML(getImageUseCase,getViewItemUseCase,view);
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.showGroups(1);
        presenter.showGroups(2);
        presenter.showGroups(3);
        presenter.showGroups(4);
    }
}
