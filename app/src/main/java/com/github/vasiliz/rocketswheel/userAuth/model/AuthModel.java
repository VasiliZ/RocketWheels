package com.github.vasiliz.rocketswheel.userAuth.model;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.authServise.AuthUserCallback;

public class AuthModel implements IAuthModel {

    private AuthUserCallback mAuthUserCallback;

    @Override
    public boolean checkConnection() {

        return true;
    }

    public void startAuthProcess(@NonNull final AuthUserCallback pAuthUserCallback) {
        mAuthUserCallback = pAuthUserCallback;

    }



}
