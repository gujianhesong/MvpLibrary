package com.pinery.mvp.di.components;

import android.content.Context;
import com.pinery.mvp.App;
import com.pinery.mvp.di.modules.AppModule;
import com.pinery.mvp.di.modules.HttpMoudle;
import dagger.Component;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */
@Singleton
@Component(modules = { AppModule.class, HttpMoudle.class})
public interface AppComponent {

  void inject(App app);

  Context getContext();

  Retrofit getRetrofit();

}
