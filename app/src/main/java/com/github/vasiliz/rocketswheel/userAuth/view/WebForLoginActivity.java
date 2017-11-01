package com.github.vasiliz.rocketswheel.userAuth.view;

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

public class WebForLoginActivity extends RocketActivity implements WebClientView {

    private WebViewPresenter mWebViewPresenter;
    private ProgressDialog mProgressDialog;
    private CustomWebViewClient mCustomWebViewClient;
    private WebView mWebView;
    private SharedPreferences mSharedPreferences;
    private static final String APP_PREFERENCES = "mysettings";
    private static final String APP_TOKENNAME = "vkToken";
    private static final String URL = "https://oauth.vk.com/authorize?client_id=6218232&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.68&state=123456";

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

    public void init() {
        mWebView = findViewById(R.id.wv_for_login);
        mWebView.loadUrl(URL);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mCustomWebViewClient = new CustomWebViewClient();
        mWebView.setWebViewClient(mCustomWebViewClient);
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
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "", "Please wait...");
    }

    //todo add this method for model #2
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    public void saveToken(final String pToken){
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(APP_TOKENNAME, pToken);
        editor.apply();
    }

}
