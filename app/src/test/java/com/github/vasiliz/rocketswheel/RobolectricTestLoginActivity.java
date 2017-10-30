package com.github.vasiliz.rocketswheel;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import com.github.vasiliz.rocketswheel.userAuth.view.LoginActivity;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public class RobolectricTestLoginActivity {

    private ActivityController<LoginActivity> mLoginActivityActivityController;

    @Before
    public void setUp() {
        mLoginActivityActivityController = Robolectric.buildActivity(LoginActivity.class);


    }

    @Test
    public void testClick() {

        mLoginActivityActivityController.create();
        mLoginActivityActivityController.start();
        mLoginActivityActivityController.resume();

        LoginActivity loginActivity = mLoginActivityActivityController.get();

        boolean loginButtonIsEnabled = loginActivity.findViewById(R.id.send_auth_data).isEnabled();
        assertEquals(loginButtonIsEnabled, true);
        assertFalse(loginButtonIsEnabled);

    }
}