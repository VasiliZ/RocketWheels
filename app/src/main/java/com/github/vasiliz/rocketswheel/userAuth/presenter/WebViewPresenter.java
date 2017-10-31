package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.userAuth.model.CompliteCallBack;
import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.view.WebClientView;
import com.github.vasiliz.rocketswheel.userAuth.view.WebForLoginActivity;
import com.github.vasiliz.rokets.RocketPresenter;

public class WebViewPresenter extends RocketPresenter<WebClientView>  {

    private WebForLoginActivity mWebForLoginView;
    private final WebViewModel mWebViewModel;

    public WebViewPresenter(final WebViewModel pWebViewModel) {
        mWebViewModel = pWebViewModel;
    }

    @Override
    public void attachView(@NonNull final WebClientView pView) {
        mWebForLoginView = (WebForLoginActivity) pView;

    }

    public void showContent() {
    //todo implements this method
    }

    public void parseUrl(final String pUrl) {
//        mWebForLoginView.showProgress();
        mWebViewModel.getToken(pUrl, pS -> {
            mWebForLoginView.hideProgress();
            System.out.println(pS);
        });

    }


}
