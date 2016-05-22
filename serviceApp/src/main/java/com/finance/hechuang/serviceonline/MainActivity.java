package com.finance.hechuang.serviceonline;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.finance.hechuang.core.entities.ServiceItem;
import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.serviceonline.RVtest1.RVtest1Activity;
import com.finance.hechuang.serviceonline.RVtest1.RVtest2Activity;
import com.finance.hechuang.serviceonline.RVtest1.RVtest3Activity;
import com.finance.hechuang.serviceonline.RVtest1.RVtest4Activity;
import com.finance.hechuang.serviceonline.eventBusUtils.events.BaseEvent;
import com.finance.hechuang.serviceonline.eventBusUtils.events.LoginFailEvent;
import com.finance.hechuang.serviceonline.eventBusUtils.events.NoInternetEvent;
import com.finance.hechuang.serviceonline.logIn.LoginActivity;

import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {



    private Context me;

    public void bnClick(View view){
        switch(view.getId()){
            case R.id.bn_jump_recycler: RVtest1Activity.start(me);break;
            case R.id.bn_jump_recycler2: RVtest2Activity.start(me);break;
            case R.id.bn_jump_recycler3: RVtest3Activity.start(me);break;
            case R.id.bn_jump_recycler4: RVtest4Activity.start(me);break;
            case R.id.bn_jump_login1: LoginActivity.start(me);break;
            case R.id.bn_jump_setAutoLogin:
                ServiceApp.getInstance().securePreference.setAutoLogin(true);
                break;
            case R.id.bn_jump_noAutoLogin:
                ServiceApp.getInstance().securePreference.setAutoLogin(false);
                break;
            case R.id.bn_write:
                ServiceApp.getInstance().securePreference.secureWriteUser(new UserLogin("aaa","1234321"));
                break;

            default: break;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        me=this;
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_main);
        ServiceItem s1=new ServiceItem();
    }


    public void onEventMainThread(BaseEvent event){
        if(event instanceof NoInternetEvent) {
            Toast.makeText(me, "--no internet--please check", Toast.LENGTH_SHORT).show();
        }
        if(event instanceof LoginFailEvent) {
            Toast.makeText(me, "-密码有误- please check", Toast.LENGTH_SHORT).show();
        }

    }





}
