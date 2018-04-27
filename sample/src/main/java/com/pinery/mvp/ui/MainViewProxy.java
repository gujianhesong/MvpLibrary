package com.pinery.mvp.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.pinery.libmvp.ui.BaseMvpViewProxy;
import com.pinery.mvp.R;
import com.pinery.mvp.constract.MainConstract;
import com.pinery.mvp.model.MainModel;
import com.pinery.mvp.presenter.MainPresenter;

/**
 * mvp ViewProxy的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class MainViewProxy extends BaseMvpViewProxy<MainPresenter, MainModel> implements MainConstract.View{

  private TextView tvContent;

  public MainViewProxy(ViewGroup parent) {
    super(parent);
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
