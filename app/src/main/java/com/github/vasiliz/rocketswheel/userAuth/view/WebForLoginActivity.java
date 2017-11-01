package com.github.vasiliz.rocketswheel.userAuth.view;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.presenter.WebViewPresenter;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

import static android.content.SharedPreferences.*;

public class WebForLoginActivity extends RocketActivity implements WebClientView {

    private WebViewPresenter mWebViewPresenter;
    private ProgressDialog mProgressDialog;
    private SharedPreferences mSharedPreferences;
    private static final String APP_PREFERENCES = "mySettings";
    private static final String APP_TOKEN_NAME = "vkToken";
    private static final String URL = "https://oauth.vk.com/authorize?client_id=6218232&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=wall,friends,offline&response_type=token&v=5.68&state=123456";

    @Override
    protected RocketPresenter injectPresenter(final Application pApplication) {
        mWebViewPresenter = new WebViewPresenter(new WebViewModel());

        return mWebViewPresenter;
    }

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.web_view_for_login);
        mSharedPreferences = getSharedPreferences(APP_PREFERENCES,MODE_PRIVATE);
        init();
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void init() {
        final WebView webView = findViewById(R.id.wv_for_login);
        webView.loadUrl(URL);
        webView.getSettings().setJavaScriptEnabled(true);
        final CustomWebViewClient customWebViewClient = new CustomWebViewClient();
        webView.setWebViewClient(customWebViewClient);
    }

    public class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {

            if (url.contains("https://oauth.vk.com/blank.html#access_token=")) {
                mWebViewPresenter.parseUrl(url);
            }
            return false;
        }
    }

    //todo add this method for model #1
    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "", getResources().getString(R.string.wait));
    }

    //todo add this method for model #2
    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void saveToken(final String pToken){
        final Editor editor = mSharedPreferences.edit();
        editor.putString(APP_TOKEN_NAME, pToken);
        System.out.println(pToken);
        editor.apply();
    }

}
