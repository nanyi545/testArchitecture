package com.finance.hechuang.serviceonline;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.finance.hechuang.core.entities.ServiceItem;
import com.finance.hechuang.serviceonline.RVtest1.RVtest1Activity;
import com.finance.hechuang.serviceonline.RVtest1.RVtest2Activity;
import com.finance.hechuang.serviceonline.RVtest1.RVtest3Activity;
import com.finance.hechuang.serviceonline.RVtest1.RVtest4Activity;

public class MainActivity extends AppCompatActivity {



    private Context me;

    public void bnClick(View view){
        switch(view.getId()){
            case R.id.bn_jump_recycler: RVtest1Activity.start(me);break;
            case R.id.bn_jump_recycler2: RVtest2Activity.start(me);break;
            case R.id.bn_jump_recycler3: RVtest3Activity.start(me);break;
            case R.id.bn_jump_recycler4: RVtest4Activity.start(me);break;
            default: break;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        me=this;
        setContentView(R.layout.activity_main);
        ServiceItem s1=new ServiceItem();
    }






}
