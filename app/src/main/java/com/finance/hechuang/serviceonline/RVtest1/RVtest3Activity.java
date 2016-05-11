package com.finance.hechuang.serviceonline.RVtest1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.finance.hechuang.datalayer.dataSource.implementations.mainPage.MainPageIML;
import com.finance.hechuang.datalayer.dataSource.implementations.mainPage.MainPageSource;
import com.finance.hechuang.serviceonline.R;
import com.finance.hechuang.serviceonline.RVtest1.utils.RecyclerListAdapter;

public class RVtest3Activity extends AppCompatActivity {

    public static void start(Context context){
        Intent i1=new Intent(context,RVtest3Activity.class);
        context.startActivity(i1);
    }


    private RecyclerView mRecyclerView;
    private RecyclerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtest3);

        MainPageSource dataStore1=new MainPageIML(this);

        adapter = new RecyclerListAdapter(this, dataStore1.getViewItems(1));

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }




}
