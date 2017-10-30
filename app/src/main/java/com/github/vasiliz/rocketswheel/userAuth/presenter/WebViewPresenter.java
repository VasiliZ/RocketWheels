package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.view.WebForLoginView;
import com.github.vasiliz.rokets.RocketPresenter;

public class WebViewPresenter extends RocketPresenter<WebForLoginView> {
    private WebForLoginView mWebForLoginView;
    private final WebViewModel mWebViewModel;

    public WebViewPresenter(WebViewModel pWebViewModel) {
        mWebViewModel = pWebViewModel;
    }

    @Override
    public void attachView(@NonNull WebForLoginView pView) {
        pView = mWebForLoginView;
    }
}
