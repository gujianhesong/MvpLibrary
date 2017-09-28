package com.pinery.mvp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.widget.TextView;
import com.pinery.libmvp.ui.BaseDialog;
import com.pinery.mvp.R;
import com.pinery.mvp.constract.MainConstract;
import com.pinery.mvp.model.MainModel;
import com.pinery.mvp.presenter.MainPresenter;

/**
 * mvp Dialog的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class MainDialog extends BaseDialog<MainPresenter, MainModel> implements MainConstract.View{

  private TextView tvContent;

  public MainDialog(@NonNull Context context) {
    super(context);
  }

  public MainDialog(@NonNull Context context, @StyleRes int themeResId) {
    super(context, themeResId);
  }

  protected MainDialog(@NonNull Context context, boolean cancelable,
      @Nullable OnCancelListener cancelListener) {
    super(context, cancelable, cancelListener);
  }

  @Override public int getLayoutId() {
    return R.layout.fragment_first;
  }

  @Override public void initViews(View view) {
    tvContent = (TextView) view.findViewById(R.id.tv_content);
    tvContent.getLayoutParams();
  }

  @Override public void initData() {
    mPresenter.requestContent("http://www.baidu.com");
  }

  @Override public void setContent(String content) {
    if(content != null){
      tvContent.setText(content);
    }
  }


}
