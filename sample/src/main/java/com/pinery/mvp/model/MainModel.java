package com.pinery.mvp.model;

import android.os.Environment;
import com.pinery.libmvp.callback.ModelCallBack;
import com.pinery.mvp.App;
import com.pinery.mvp.constract.MainConstract;
import java.io.File;
import java.io.IOException;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hesong on 2017/9/28.
 */

public class MainModel implements MainConstract.Model {

  @Override public void requestContent(String url, final ModelCallBack<String> callBack) {
    if(callBack == null) return;

    final Request request = new Request.Builder().url("http://blog.csdn.net/hesong1120/article/details/78523308").build();

    Cache cache = new Cache(new File(Environment.getExternalStorageDirectory() + "/" + "dirOkhttp"), 50 * 1024 * 1024);
    OkHttpClient client = new OkHttpClient.Builder().cache(cache).build();
    client.newCall(request).enqueue(new Callback() {

      @Override public void onFailure(Call call, IOException e) {
        callBack.onFailure(e);
      }

      @Override public void onResponse(Call call, Response response) throws IOException {
        final String content = response.body().string();
        App.getInstance().mHandler.post(new Runnable() {
          @Override public void run() {

              callBack.onSuccess(content);

          }
        });

      }

    });
  }

}
