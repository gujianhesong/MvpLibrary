package com.pinery.libmvp.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import com.pinery.libmvp.model.BaseModel;
import com.pinery.libmvp.presenter.BasePresenter;
import com.pinery.libmvp.util.ClassUtil;

/**
 * 实现mvp模式的基类Dialog
 *
 * Created by hesong on 2017/9/28.
 */

public abstract class BaseDialog<P extends BasePresenter, M extends BaseModel> extends Dialog {

  protected P mPresenter;
  protected M mModel;

  public BaseDialog(@NonNull Context context) {
    super(context);

    init(context);
  }

  public BaseDialog(@NonNull Context context, @StyleRes int themeResId) {
    super(context, themeResId);

    init(context);
  }

  protected BaseDialog(@NonNull Context context, boolean cancelable,
      @Nullable OnCancelListener cancelListener) {
    super(context, cancelable, cancelListener);

    init(context);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  private void init(Context context){

    //反射new出第1个泛型类型的对象
    mPresenter = ClassUtil.getT(this, 0);
    //反射new出第2个泛型类型的对象
    mModel = ClassUtil.getT(this, 1);

    View mView = LayoutInflater.from(context).inflate(getLayoutId(), null);

    setContentView(mView);

    initViews(mView);

  }

  @Override public void show() {
    super.show();

    //将M,V,P三层绑定，P持有M,V的引用
    mPresenter.attachModelView(mModel, this);

    initData();

  }

  @Override public void dismiss() {
    super.dismiss();

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
