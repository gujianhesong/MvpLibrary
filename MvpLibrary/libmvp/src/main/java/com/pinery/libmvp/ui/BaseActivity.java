package com.pinery.libmvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.pinery.libmvp.model.BaseModel;
import com.pinery.libmvp.presenter.BasePresenter;
import com.pinery.libmvp.util.ClassUtil;

/**
 * 实现mvp模式的基类Activity
 *
 * Created by hesong on 2017/9/28.
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity {

  protected P mPresenter;
  protected M mModel;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(getLayoutId());

    //反射new出第1个泛型类型的对象
    mPresenter = ClassUtil.getT(this, 0);
    //反射new出第2个泛型类型的对象
    mModel = ClassUtil.getT(this, 1);

    if(mPresenter != null && mModel != null){
      //将M,V,P三层绑定，P持有M,V的引用
      mPresenter.attachModelView(mModel, this);
    }

    initViews();

    initData();
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    if(mPresenter != null){
      mPresenter.onDettach();
    }
  }

  /**
   * 提供布局id
   * @return
   */
  public abstract int getLayoutId();

  /**
   * 初始化view
   */
  public abstract void initViews();

  /**
   * 初始化数据
   */
  public abstract void initData();



}
