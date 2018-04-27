package com.pinery.libmvp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.libmvp.model.BaseModel;
import com.pinery.libmvp.presenter.BasePresenter;
import com.pinery.libmvp.util.ClassUtil;

/**
 * 实现mvp模式的基类ViewProxy, 用于管理特定的逻辑视图模块
 *
 * Created by hesong on 2017/9/28.
 */

public abstract class BaseMvpViewProxy<P extends BasePresenter, M extends BaseModel> implements IViewProxy{

  protected P mPresenter;
  protected M mModel;

  protected Context mContext;
  protected View mView;
  protected ViewGroup mParent;

  public BaseMvpViewProxy(ViewGroup parent){

    if(parent == null) throw new IllegalArgumentException("parent is null");

    mParent = parent;
    mContext = parent.getContext();

    //反射new出第1个泛型类型的对象
    mPresenter = ClassUtil.getT(this, 0);
    //反射new出第2个泛型类型的对象
    mModel = ClassUtil.getT(this, 1);

    mView = LayoutInflater.from(mContext).inflate(getLayoutId(), null);

    if(mView == null) throw new IllegalArgumentException("getLayoutId() is invalid");

    initViews(mView);

  }

  public View getView(){
    return mView;
  }

  @Override
  public void show(){
    if(mView.getParent() == null){
      mParent.addView(mView);
    }

    //将M,V,P三层绑定，P持有M,V的引用
    mPresenter.attachModelView(mModel, this);

    initData();

  }

  @Override
  public void dismiss(){
    if(mView.getParent() != null){
      ((ViewGroup)mView.getParent()).removeView(mView);
    }

    mPresenter.onDettach();
  }

  @Override public boolean isShowing() {
    return mView.getParent() != null;
  }

  /**
   * 提供布局id
   * @return
   */
  public abstract int getLayoutId();

  /**
   * 初始化view
   */
  public abstract void initViews(View view);

  /**
   * 初始化数据
   */
  public abstract void initData();



}
