package com.github.vasiliz.rocketswheel;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
    }


    public static Context getContext(){
        return MyApp.mContext;
    }
}
