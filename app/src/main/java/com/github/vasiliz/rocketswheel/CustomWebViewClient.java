package com.github.vasiliz.rocketswheel;

import android.content.SharedPreferences;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CustomWebViewClient extends WebViewClient {

    private SharedPreferences mSharedPreferences;

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if (url.contains("https://oauth.vk.com/blank.html#access_token=")) {
            Log.d("TAG", url);
        }

        return false;
    }
}
