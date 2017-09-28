package com.pinery.libmvp.ui;

import android.view.View;

/**
 * ViewProxy接口
 *
 * Created by hesong on 2017/9/28.
 */

public interface IViewProxy {

  /**
   * 获取View
   * @return
   */
  View getView();

  /**
   * 显示
   */
  void show();

  /**
   * 隐藏
   */
  void dismiss();

  /**
   * 是否正在显示
   * @return
   */
  boolean isShowing();

}
