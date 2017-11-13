package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.userAuth.model.AuthModel;
import com.github.vasiliz.rocketswheel.userAuth.view.LoginActivity;
import com.github.vasiliz.rocketswheel.userAuth.view.UserAuthView;
import com.github.vasiliz.rokets.RocketPresenter;

public class UserIAuthPresenter extends RocketPresenter<UserAuthView> implements IAuthUserCallback {

    private final AuthModel mAuthModel;
    private UserAuthView mLoginActivity;

    public UserIAuthPresenter(final AuthModel pAuthModel) {
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
        mLoginActivity.onLogin();
    }

    @Override
    public void attachView(@NonNull final UserAuthView pView) {
        mLoginActivity = pView;
    }
}
