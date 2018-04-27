package com.pinery.mvp.di.modules;

import android.content.Context;
import com.pinery.mvp.App;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */
@Module
public class AppModule {

  private App mApp;

  public AppModule(App app){
    mApp = app;
  }

  @Provides
  @Singleton
  Context provideApplicationContext(){
    return mApp;
  }

}
