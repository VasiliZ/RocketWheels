package com.github.vasiliz.rocketswheel.userAuth.model;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.authServise.AuthUserCallback;

public interface IAuthModel {

    void startAuthProcess(@NonNull AuthUserCallback pAuthUserCallback);
    boolean checkConnection();

}
