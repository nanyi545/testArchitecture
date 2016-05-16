package com.finance.hechuang.serviceonline.logIn;

import com.finance.hechuang.core.entities.User;
import com.finance.hechuang.serviceonline.presenter.Presenter;
import com.finance.hechuang.serviceonline.views.LoadDataView;

/**
 * Created by Administrator on 16-5-16.
 */
public interface LogInContract {

    interface LogInPresentor extends Presenter{

    }

    interface LogInView extends LoadDataView{

        /** UI reaction on login failure **/
        void logInFail();

        /** UI reaction on login successfully **/
        void logInSuccess();

        /** get user info from UI input **/
        User getUser();

        /** click UI to start login **/
        void startLogin();


        /** register a new account **/
        void registerNewAccount();

        /** show/hide pass in the UI **/
        void showPass();
        void hidePass();

        /** forget password, get password back by phone **/
        void forgetPass();


    }



}
