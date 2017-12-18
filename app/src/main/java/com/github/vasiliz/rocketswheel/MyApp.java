package com.github.vasiliz.rocketswheel;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        MyApp.mContext = getApplicationContext();
    }

    //TODO wrong solution. Right ovveride getSystemService and return instance.
    //TODo static method and static context. Use ContextHolder.
    public static Context getContext(){
        return MyApp.mContext;
    }
}
