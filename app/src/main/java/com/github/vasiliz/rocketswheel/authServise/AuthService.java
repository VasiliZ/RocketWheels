package com.github.vasiliz.rocketswheel.authServise;

import android.content.Context;
import android.support.annotation.NonNull;

public class AuthService {

    private final Context mContext;

    public AuthService(@NonNull final Context pContext) {
        mContext = pContext;
    }

    public void checkCredentials(@NonNull final AuthUserCallback pAuthUserCallback, @NonNull final String pCredentials) {

    }

    public void authorize(@NonNull final AuthUserCallback pAuthUserCallback, @NonNull final String pCredentials) {


    }

}
