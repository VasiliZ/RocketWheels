package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

public interface IAuthUserCallback {
     void handleErrorAction(@NonNull final Throwable pThrowable);
     void toLogin();

}
