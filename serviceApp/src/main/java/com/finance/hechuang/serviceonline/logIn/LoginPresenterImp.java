package com.finance.hechuang.serviceonline.logIn;

import com.finance.hechuang.core.entities.UserLogin;
import com.finance.hechuang.datalayer.interactors.UseCase;
import com.finance.hechuang.datalayer.subscribers.DefaultSubscriber;

/**
 * Created by Administrator on 16-5-22.
 */
public class LoginPresenterImp implements LogInContract.LogInPresentor {


    private LogInContract.LogInView logInView;

    private UseCase<UserLogin> loginUseCase;


    public LoginPresenterImp(UseCase loginUseCase){
        this.loginUseCase=loginUseCase;
    }

    public LoginPresenterImp(UseCase loginUseCase,LogInContract.LogInView logInView){
        this.loginUseCase=loginUseCase;
        this.logInView=logInView;
    }


    public void setLogInView(LogInContract.LogInView logInView) {
        this.logInView = logInView;
    }



    @Override
    public void doLogin() {
        loginUseCase.execute(logInView.getUser(),new LoginSubscriber());
    }

    @Override
    public void noAccount() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }




    private final class LoginSubscriber extends DefaultSubscriber<Boolean> {

        @Override public void onCompleted() {
            logInView.hideLoading();
        }

        @Override public void onError(Throwable e) {
//            UserListPresenter.this.hideViewLoading();
//            UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
//            UserListPresenter.this.showViewRetry();
        }

        @Override public void onNext(Boolean logInSuccess) {
            if (logInSuccess) logInView.logInSuccess();
            else logInView.logInFail();
//            logInView.hideLoading(); //  ???
        }
    }









}
