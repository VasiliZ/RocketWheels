package com.github.vasiliz.rocketswheel.userAccount.presenter;

import com.github.vasiliz.rocketswheel.userAccount.model.UserModel;
import com.github.vasiliz.rocketswheel.userAccount.view.IUserAccountView;
import com.github.vasiliz.rokets.RocketPresenter;

public class UserActivityPresenter extends RocketPresenter<IUserAccountView> {

    public UserActivityPresenter(final UserModel pUserModel) {

    }

    @Override
    public void messageOkClicked() {
        super.messageOkClicked();

        getView().logout();

    }

    public void logoutClicked() {
        handleAction(new Throwable());
    }
}
