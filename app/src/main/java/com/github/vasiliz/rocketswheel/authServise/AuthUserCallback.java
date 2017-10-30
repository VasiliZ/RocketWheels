package com.github.vasiliz.rocketswheel.authServise;

import android.support.annotation.NonNull;

public interface AuthUserCallback {

    void handleErrorAction(@NonNull Throwable pThrowable);

    void toLogin();
}
