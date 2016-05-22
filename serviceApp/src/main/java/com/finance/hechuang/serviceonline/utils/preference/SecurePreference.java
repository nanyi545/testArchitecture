package com.finance.hechuang.serviceonline.utils.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.serviceonline.utils.constants.SerConstents;
import com.finance.hechuang.serviceonline.utils.encrypt.EncrypAES;

/**
 * Created by Administrator on 16-5-21.
 */
public class SecurePreference {


    private Context context;
    private SharedPreferences sp;


    //------ constructor -----
    public SecurePreference(Context context){
        this.context=context;
        sp=this.context.getSharedPreferences(SerConstents.SP_KEY, Context.MODE_PRIVATE);
    }

    /** ----------  write/get UserLogin  ---------- **/
    public void secureWriteUser(UserLogin login){
        String user=login.userId;
        String pass=login.pass;
        if (user!=null){
            secureWrite(SerConstents.SP_USER,user);
        }
        if (pass!=null){
            secureWrite(SerConstents.SP_PASS,pass);
        }
    }
    public UserLogin secureGetUser( ){
        String user= secureRead(SerConstents.SP_USER);
        String pass= secureRead(SerConstents.SP_PASS);
        return new UserLogin(user,pass);
    }


    /** ----------  write/get auto-login  ---------- **/
    public boolean getAutoLogin(){
        return sp.getBoolean(SerConstents.SP_AUTOLOGIN_KEY,false);
    }
    public void setAutoLogin(boolean yn){
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean(SerConstents.SP_AUTOLOGIN_KEY,yn);
        editor.commit();
    }



    private void secureWrite(String key,String str){
        String encrypted= EncrypAES.getInstance().encrypt(str);
        String encryptedKey= EncrypAES.getInstance().encrypt(key);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(encryptedKey,encrypted);
        editor.commit();
    }
    private String secureRead(String key){
        String encryptedKey= EncrypAES.getInstance().encrypt(key);
        String endrypted=sp.getString(encryptedKey,"");
        return EncrypAES.getInstance().decrypt(endrypted);
    }




}
