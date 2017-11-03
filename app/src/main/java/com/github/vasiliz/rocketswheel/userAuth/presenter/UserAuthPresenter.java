package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.userAuth.model.AuthModel;
import com.github.vasiliz.rocketswheel.userAuth.view.LoginActivity;
import com.github.vasiliz.rocketswheel.userAuth.view.UserAuthView;
import com.github.vasiliz.rokets.RocketPresenter;

public class UserAuthPresenter extends RocketPresenter<UserAuthView> implements AuthUserCallback {

    private final AuthModel mAuthModel;
    private LoginActivity mLoginActivity;

    public UserAuthPresenter(final AuthModel pAuthModel) {
        mAuthModel = pAuthModel;
    }

    @Override
    public void handleErrorAction(@NonNull final Throwable pThrowable) {
        hideProgress();
        handleAction(pThrowable);
    }

    @Override
    public void toLogin() {
        mAuthModel.checkConnection();
        //        TODO UserAuthView.onLogin() and start activity inside
        // mAuthModel.startAuthProcess(this);
        mLoginActivity.startingActivity();

    }

    @Override
    public void attachView(@NonNull UserAuthView pView) {
        //        TODO Use interfase instead LoginActivity
        mLoginActivity = (LoginActivity) pView;
    }
}
