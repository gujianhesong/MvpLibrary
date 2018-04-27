package com.pinery.mvp.ui;

import android.view.View;
import android.widget.TextView;
import com.pinery.libmvp.ui.BaseMvpFragment;
import com.pinery.mvp.R;
import com.pinery.mvp.constract.SecondConstract;
import com.pinery.mvp.model.SecondModel;
import com.pinery.mvp.presenter.SecondPresenter;

/**
 * mvp Fragment的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class SecondFragment extends BaseMvpFragment<SecondPresenter, SecondModel> implements
    SecondConstract.View{

  private TextView tvContent;

  @Override public int getLayoutId() {
    return R.layout.fragment_second;
  }

  @Override public void initViews(View view) {

    tvContent = (TextView) view.findViewById(R.id.tv_content);
  }

  @Override public void initData() {
    mPresenter.requestContent("http://www.sougou.com");
  }

  @Override public void setContent(String content) {
    if(content != null){
      tvContent.setText(content);
    }
  }
}
