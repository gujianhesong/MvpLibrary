package com.pinery.mvp.presenter;

import com.pinery.libmvp.callback.ModelCallBack;
import com.pinery.mvp.bean.Joke;
import com.pinery.mvp.constract.MainConstract;
import com.pinery.mvp.constract.StoryConstract;

/**
 * 表现层的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class StoryPresenter extends StoryConstract.Presenter {

  @Override public void requestContent() {
    getModel().requestContent(new ModelCallBack<Joke>() {
      @Override public void onSuccess(Joke joke) {
        if(getView() != null){
          getView().showJoke(joke);
        }
      }

      @Override public void onFailure(Throwable throwable) {
        if(getView() != null){
          getView().toastError(throwable);
        }
      }
    });
  }

}
