package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

interface AuthUserCallback {
    public void handleErrorAction(@NonNull final Throwable pThrowable);
    public void toLogin();

}
