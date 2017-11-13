package com.github.vasiliz.rocketswheel.userAuth.view;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.userAuth.model.AuthModel;
import com.github.vasiliz.rocketswheel.userAuth.presenter.UserIAuthPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

public class LoginActivity extends RocketActivity implements UserAuthView {

    private UserIAuthPresenter mUserAuthPresenter;

    @Override
    public void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_login);
    }


    public void onLoginButtonClicked(final View view) {
        mUserAuthPresenter.toLogin();
    }

    @Override
    protected RocketPresenter injectPresenter(final Application pApplication) {
        mUserAuthPresenter = new UserIAuthPresenter(new AuthModel());
        mUserAuthPresenter.attachView(this);
        return mUserAuthPresenter;
    }

    @Override
    public void onLogin() {
        startActivity(new Intent(this, WebForLoginActivity.class));
    }

}
