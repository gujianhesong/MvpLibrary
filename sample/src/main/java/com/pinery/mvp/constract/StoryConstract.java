package com.pinery.mvp.constract;

import com.pinery.libmvp.callback.ModelCallBack;
import com.pinery.libmvp.constract.BaseConstract;
import com.pinery.libmvp.model.BaseModel;
import com.pinery.libmvp.presenter.BasePresenter;
import com.pinery.libmvp.view.BaseView;
import com.pinery.mvp.bean.Joke;

/**
 * 契约接口，本身不提供任何数据或方法
 *
 * Created by hesong on 2017/9/28.
 */

public interface StoryConstract extends BaseConstract {

  interface Model extends BaseModel{
    void requestContent(ModelCallBack<Joke> callBack);
  }

  interface View extends BaseView {
    void showJoke(Joke joke);
    void toastError(Throwable throwable);
  }

  abstract class Presenter extends BasePresenter<Model, View>{
    public abstract void requestContent();
  }

}
