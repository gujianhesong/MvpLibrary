package com.pinery.mvp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.pinery.mvp.di.components.AppComponent;
import com.pinery.mvp.di.components.DaggerAppComponent;
import com.pinery.mvp.di.modules.AppModule;
import com.pinery.mvp.di.modules.HttpMoudle;

/**
 *
 */
public class App extends Application {
    private AppComponent mAppComponent;

    public static App sApp = null;
    public Handler mHandler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());

        sApp = this;

        initInjector();

    }

    private void initInjector(){
        mAppComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .httpMoudle(new HttpMoudle("     "))
            .build();

    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public static Context getContext(){
        return sApp;
    }

    public static App getInstance(){
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
