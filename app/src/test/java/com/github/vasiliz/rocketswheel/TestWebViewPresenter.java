package com.github.vasiliz.rocketswheel;

import com.github.vasiliz.rocketswheel.userAuth.model.ICompliteCallBack;
import com.github.vasiliz.rocketswheel.userAuth.model.WebViewModel;
import com.github.vasiliz.rocketswheel.userAuth.presenter.WebViewPresenter;
import com.github.vasiliz.rocketswheel.userAuth.presenter.IWebViewPresenterContract;
import com.github.vasiliz.rocketswheel.userAuth.view.IWebClientView;
import com.github.vasiliz.rocketswheel.userAuth.view.WebForLoginActivity;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class TestWebViewPresenter {

    private IWebViewPresenterContract mWebViewPresenter;
    private ICompliteCallBack mICompliteCallBack;
    private WebViewModel mWebViewModel;
    private IWebClientView mWebForLoginActivity;
    private String urlForSample = "https://oauth.vk.com/blank.html#access_token=5226840b34984c42b4e252abf4f4e37be7950b6f2a91fbe1dc6754c924290f9c1e7d109e3bbf987831dc8&expires_in=86400&user_id=8679312&state=123456";
    private String mString = "https://oauth.vk.com/authorize?client_id=6218232&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.68&state=123456";

    @Before
    public void init() {

        mWebForLoginActivity = new WebForLoginActivity();
        mWebViewModel = mock(WebViewModel.class);
        mWebViewPresenter = mock(WebViewPresenter.class);
        mICompliteCallBack = mock(ICompliteCallBack.class);

    }

    @Test
    public void testParseUrl() {
        mWebViewPresenter.parseUrl(mString);
        mWebViewModel.getToken(urlForSample, mICompliteCallBack);
        verify(mWebViewModel).getToken(urlForSample, mICompliteCallBack);
    }

}
