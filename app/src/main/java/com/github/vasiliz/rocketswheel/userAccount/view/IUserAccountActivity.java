package com.github.vasiliz.rocketswheel.userAccount.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.vasiliz.rocketswheel.userAccount.model.UserModel;
import com.github.vasiliz.rocketswheel.userAccount.presenter.UserActivityPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

public class IUserAccountActivity extends RocketActivity implements IUserAccountView {

    private UserActivityPresenter mUserActivityPresenter;

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
      //  setContentView(R.layout.activity_user); todo implenemts for user profile activity
    }

    public void showMessage(final View pView) {
        mUserActivityPresenter.logoutClicked();
    }

    @Override
    public void showMe() {

    }

    @Override
    public void logout() {

    }

    @Override
    protected RocketPresenter injectPresenter(final Application pApplication) {

        mUserActivityPresenter = new UserActivityPresenter(new UserModel());
        return mUserActivityPresenter;
    }
}
