package com.github.vasiliz.rocketswheel.userAuth.view;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.github.vasiliz.rocketswheel.CustomWebViewClient;
import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.presenter.WebViewPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

public class WebForLoginView extends RocketActivity {

    private WebViewPresenter mWebViewPresenter;
    private WebView mWebView;
    private WebViewModel mWebViewModel;
    private String URL = "https://oauth.vk.com/authorize?client_id=6218232&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.68&state=123456";

    @Override
    protected RocketPresenter injectPresenter(final Application pApplication) {
        mWebViewPresenter = new WebViewPresenter(mWebViewModel);
        return mWebViewPresenter;
    }

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.web_view_for_login);
        init();

    }

    public void init(){
        mWebViewPresenter.attachView(this);
        mWebView = findViewById(R.id.wv_for_login);
        mWebView.loadUrl(URL);
        // mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new CustomWebViewClient());
    }


}
