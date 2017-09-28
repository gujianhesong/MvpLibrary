package com.pinery.libmvp.presenter;

import java.lang.ref.WeakReference;

/**
 * 最底层的表现层P, 绑定最底层的模型层BaseModel和BaseView，并管理BaseView的引用
 *
 * Created by hesong on 2017/9/28.
 */

public abstract class BasePresenter<BaseModel, BaseView> {

  private BaseModel mModel;
  private WeakReference<BaseView> mViewRef;

  public void attachModelView(BaseModel model, BaseView view){
    mModel = model;
    mViewRef = new WeakReference<BaseView>(view);
  }

  public BaseView getView(){
    if(isAttached()){
      return mViewRef.get();
    }
    return null;
  }

  public BaseModel getModel(){
    return mModel;
  }

  public boolean isAttached(){
    return mViewRef != null && mViewRef.get() != null;
  }

  public void onDettach(){
    if(mViewRef != null){
      mViewRef.clear();
      mViewRef = null;
    }
  }

}
