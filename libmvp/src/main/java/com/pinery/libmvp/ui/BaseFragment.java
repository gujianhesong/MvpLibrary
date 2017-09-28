package com.pinery.libmvp.ui;

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
 * 实现mvp模式的基类Fragment
 *
 * Created by hesong on 2017/9/28.
 */

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment {

  protected P mPresenter;
  protected M mModel;

  protected View mView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    //反射new出第1个泛型类型的对象
    mPresenter = ClassUtil.getT(this, 0);
    //反射new出第2个泛型类型的对象
    mModel = ClassUtil.getT(this, 1);

    //将M,V,P三层绑定，P持有M,V的引用
    mPresenter.attachModelView(mModel, this);

    mView = inflater.inflate(getLayoutId(), null);

    return mView;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    initViews(view);

    initData();

  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    mPresenter.onDettach();
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
