package com.pinery.libmvp.callback;

/**
 * 模型层回调接口
 *
 * Created by hesong on 2017/9/28.
 */

public interface ModelCallBack<E> {

  /**
   * 请求成功数据返回
   * @param e
   */
  void onSuccess(E e);

  /**
   * 请求失败返回
   * @param throwable
   */
  void onFailure(Throwable throwable);

}
