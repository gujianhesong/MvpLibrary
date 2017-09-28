package com.pinery.mvp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 *
 */
public class MvpApp extends Application {

    public static MvpApp sApp = null;
    public Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();

        sApp = this;

    }

    public static Context getContext(){
        return sApp;
    }

    public static MvpApp getInstance(){
        return sApp;
    }

    public Handler getHandler(){
        return mHandler;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }

}
