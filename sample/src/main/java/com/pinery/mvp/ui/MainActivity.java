package com.pinery.mvp.ui;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.pinery.libmvp.ui.BaseActivity;
import com.pinery.mvp.R;
import com.pinery.mvp.constract.MainConstract;
import com.pinery.mvp.model.MainModel;
import com.pinery.mvp.presenter.MainPresenter;

/**
 * mvp Activity的一个具体实现
 *
 * Created by hesong on 2017/9/28.
 */

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements
    MainConstract.View{

  private Button btnGoStory, btnGoFragment, btnDialog, btnViewProxy;
  private TextView tvContent;
  private FrameLayout viewProxyContainer;

  private MainViewProxy mainViewProxy;

  @Override public int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override public void initViews() {
    btnGoStory = (Button) findViewById(R.id.btn_story);
    btnGoFragment = (Button) findViewById(R.id.btn_fragment);
    btnDialog = (Button) findViewById(R.id.btn_dialog);
    btnViewProxy = (Button) findViewById(R.id.btn_viewproxy);

    tvContent = (TextView) findViewById(R.id.tv_content);
    viewProxyContainer = (FrameLayout) findViewById(R.id.viewproxy_container);

    btnGoStory.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        //打开故事页面
        startActivity(new Intent(MainActivity.this, StoryActivity.class));
      }
    });

    btnGoFragment.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        //打开多Fragment页面
        startActivity(new Intent(MainActivity.this, FragmentActivity.class));
      }
    });

    btnDialog.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        //打开Diaglog
        MainDialog dialog = new MainDialog(MainActivity.this);
        dialog.show();

      }
    });

    btnViewProxy.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {

        //显示隐藏Veiwproxy
        if(mainViewProxy == null){
          mainViewProxy = new MainViewProxy(viewProxyContainer);
        }

        if(mainViewProxy.isShowing()){
          mainViewProxy.dismiss();
        }else{
          mainViewProxy.show();
        }

      }
    });

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
