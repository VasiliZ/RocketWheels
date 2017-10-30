package com.github.vasiliz.rocketswheel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.github.vasiliz.rocketswheel.userAuth.view.LoginActivity;

public class App extends android.app.Application {



    private Application mApplication;

    public App(Application pApplication) {
        mApplication = pApplication;
    }

   /* public App() {
    }

    VKAccessTokenTracker mVKAccessToken = new VKAccessTokenTracker() {

        @Override
        public void onVKAccessTokenChanged(@Nullable VKAccessToken oldToken, @Nullable VKAccessToken newToken) {
            if (newToken == null) {
                Toast.makeText(mApplication, "AccessToken invalided", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mApplication, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(mApplication = (Application) getApplicationContext());
        mVKAccessToken.startTracking();


    }*/
}
