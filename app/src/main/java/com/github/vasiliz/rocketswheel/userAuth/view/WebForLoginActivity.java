package com.github.vasiliz.rocketswheel.userAuth.view;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.github.vasiliz.rocketswheel.R;
import com.github.vasiliz.rocketswheel.commons.ConstantsStrings;
import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.presenter.WebViewPresenter;
import com.github.vasiliz.rocketswheel.userVkNews.view.UserVkNewsView;
import com.github.vasiliz.rokets.RocketActivity;
import com.github.vasiliz.rokets.RocketPresenter;

import static android.content.SharedPreferences.Editor;

public class WebForLoginActivity extends RocketActivity implements IWebClientView {

    private WebViewPresenter mWebViewPresenter;
    private ProgressDialog mProgressDialog;
    private SharedPreferences mSharedPreferences;
    private static final String URL = ConstantsStrings.URL_AUTH;

    @Override
    protected RocketPresenter injectPresenter(final Application pApplication) {
        mWebViewPresenter = new WebViewPresenter(new WebViewModel());

        return mWebViewPresenter;
    }

    @Override
    public void onCreate(@Nullable final Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.layout_web_view_login);
        if (!checkAuth()) {
            afterCheckCredentials();
        } else {
            init();
        }
        mSharedPreferences = getSharedPreferences(ConstantsStrings.APP_PREFERENCES, MODE_PRIVATE);

    }

    @SuppressLint("SetJavaScriptEnabled")
    public void init() {


            final WebView webView = findViewById(R.id.web_view_login);
            webView.loadUrl(URL);
            webView.getSettings().setJavaScriptEnabled(true);
            final CustomWebViewClient customWebViewClient = new CustomWebViewClient();
            webView.setWebViewClient(customWebViewClient);

    }

    public class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(final WebView view, final String url) {

            if (url.contains(ConstantsStrings.URL_GET_ACCESS_TOKEN)) {
                mWebViewPresenter.parseUrl(url);
            }
            return false;
        }
    }

    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "", getResources().getString(R.string.wait));
    }

    @Override
    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void saveToken(final String pToken) {
        final Editor editor = mSharedPreferences.edit();
        editor.putString(ConstantsStrings.APP_TOKEN_NAME, pToken);
        System.out.println(pToken);
        editor.apply();
    }

    @Override
    public void afterCheckCredentials() {
        startActivity(new Intent(this, UserVkNewsView.class));
    }

    public boolean checkAuth(){
        final SharedPreferences sharedPreferences = getSharedPreferences(ConstantsStrings.APP_PREFERENCES, MODE_PRIVATE);
        if (sharedPreferences.getString(ConstantsStrings.APP_TOKEN_NAME, "")!=null) {
            return true;
        }else {
            return false;
        }
    }

}
