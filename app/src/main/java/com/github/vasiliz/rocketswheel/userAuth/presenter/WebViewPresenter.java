package com.github.vasiliz.rocketswheel.userAuth.presenter;

import android.support.annotation.NonNull;

import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.view.IWebClientView;
import com.github.vasiliz.rocketswheel.userAuth.view.WebForLoginActivity;
import com.github.vasiliz.rokets.RocketPresenter;

public class WebViewPresenter extends RocketPresenter<IWebClientView> implements IWebViewPresenterContract {

    private IWebClientView mWebForLoginView;
    private final WebViewModel mWebViewModel;

    public WebViewPresenter(final WebViewModel pWebViewModel) {
        mWebViewModel = pWebViewModel;
    }

    @Override
    public void attachView(@NonNull final IWebClientView pView) {
        mWebForLoginView =  pView;

    }
    @Override
    public void showContent() {
    //todo implements this method
    }

    @Override
    public void parseUrl(final String pUrl) {
        mWebForLoginView.showProgress();
        mWebViewModel.getToken(pUrl, pS -> {
            mWebForLoginView.saveToken(pS);
            mWebForLoginView.hideProgress();
            mWebForLoginView.afterCheckCredentials();

        });
    }


}
