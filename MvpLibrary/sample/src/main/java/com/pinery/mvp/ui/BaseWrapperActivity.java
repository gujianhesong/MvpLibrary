package com.pinery.mvp.ui;

import android.app.ProgressDialog;
import com.pinery.libmvp.model.BaseModel;
import com.pinery.libmvp.presenter.BasePresenter;
import com.pinery.libmvp.ui.BaseActivity;

/**
 * 包装后的BaseActivity，提供更多方法接口
 *
 * Created by hesong on 2017/9/28.
 */

public abstract class BaseWrapperActivity<P extends BasePresenter, M extends BaseModel> extends BaseActivity<P, M> {

  private ProgressDialog mProgressDialog;

  /**
   * 显示进度框
   */
  public void showProgressDialog(){
    if(mProgressDialog == null){
      mProgressDialog = new ProgressDialog(this);
    }

    if(!mProgressDialog.isShowing()){
      mProgressDialog.show();
    }
  }

  /**
   * 取消进度框
   */
  public void dismissProgressDialog(){
    if(mProgressDialog != null && mProgressDialog.isShowing()){
      mProgressDialog.dismiss();
    }
  }


}
