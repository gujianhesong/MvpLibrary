package com.pinery.mvp.presenter;

import com.pinery.libmvp.callback.ModelCallBack;
import com.pinery.mvp.constract.MainConstract;
import com.pinery.mvp.model.MainModel;

/**
 * 表现层的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class MainPresenter extends MainConstract.Presenter {

  @Override public void requestContent(String url) {
    getModel().requestContent(url, new ModelCallBack<String>() {
      @Override public void onSuccess(String s) {
        if(getView() != null){
          getView().setContent(s);
        }
      }

      @Override public void onFailure(Throwable throwable) {
        if(getView() != null){
          getView().setContent(throwable.getMessage());
        }
      }
    });
  }

}
