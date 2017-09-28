package com.pinery.mvp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pinery.libmvp.callback.ModelCallBack;
import com.pinery.mvp.bean.Joke;
import com.pinery.mvp.constract.MainConstract;
import com.pinery.mvp.constract.StoryConstract;
import com.pinery.mvp.request.JokeService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 *
 * http://api.jisuapi.com/xiaohua/text?pagenum=10&pagesize=3&appkey=9814b57c706d0a23
 *
 * Created by hesong on 2017/9/28.
 */

public class StoryModel implements StoryConstract.Model {

  private static final String STRORY_BASE_URL = "http://api.jisuapi.com/xiaohua/";
  private static final String STRORY_APP_KEY = "9814b57c706d0a23";


  @Override public void requestContent(final ModelCallBack<Joke> callBack) {
    if(callBack == null) return;

    //gson
    final Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .serializeNulls()
        .create();

    //初始化OkHttpClient
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder()
        //.addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(15, TimeUnit.SECONDS)
        //.addNetworkInterceptor(authorizationInterceptor)
        .build();

    //初始化Retrofit
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(STRORY_BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    JokeService apiService = retrofit.create(JokeService.class);
    apiService.requestJoke(1, 30, STRORY_APP_KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Joke>() {
          @Override public void call(Joke joke) {
            callBack.onSuccess(joke);
          }
        }, new Action1<Throwable>() {
          @Override public void call(Throwable throwable) {
            callBack.onFailure(throwable);
          }
        });

  }

}
