package com.pinery.mvp.ui;

import android.view.View;
import android.widget.TextView;
import com.pinery.libmvp.ui.BaseMvpFragment;
import com.pinery.mvp.R;
import com.pinery.mvp.constract.FirstConstract;
import com.pinery.mvp.model.FirstModel;
import com.pinery.mvp.presenter.FirstPresenter;

/**
 * mvp Fragment的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class FirstFragment extends BaseMvpFragment<FirstPresenter, FirstModel> implements
    FirstConstract.View{

  private TextView tvContent;

  @Override public int getLayoutId() {
    return R.layout.fragment_first;
  }

  @Override public void initViews(View view) {

    tvContent = (TextView) view.findViewById(R.id.tv_content);
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
