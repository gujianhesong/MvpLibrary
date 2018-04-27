package com.pinery.mvp.di.modules;

import android.content.Context;
import com.pinery.mvp.common.http.OkhttpFactory;
import com.pinery.mvp.common.http.RetrofitFactory;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * @author hesong
 * @time 2018/1/17
 * @desc
 */

@Module
public class HttpMoudle {
  private final String baseUrl;

  public HttpMoudle(String baseUrl){
    this.baseUrl = baseUrl;
  }

  @Provides
  @Singleton
  public Retrofit provideRetrofit(Context context){
    return RetrofitFactory.createGsonWithRxJavaRetrofit(baseUrl, provideOkhttpClient(context));
  }

  @Provides
  @Singleton
  public OkHttpClient provideOkhttpClient(Context context){
    return OkhttpFactory.create(context);
  }

}
