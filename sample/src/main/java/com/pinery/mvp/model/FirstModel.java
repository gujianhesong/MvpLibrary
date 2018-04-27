package com.pinery.mvp.model;

import com.pinery.libmvp.callback.ModelCallBack;
import com.pinery.mvp.App;
import com.pinery.mvp.constract.FirstConstract;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by hesong on 2017/9/28.
 */

public class FirstModel implements FirstConstract.Model {

  @Override public void requestContent(String url, final ModelCallBack<String> callBack) {
    if(callBack == null) return;

    Request request = new Request.Builder().url(url).build();

    OkHttpClient client = new OkHttpClient();
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
