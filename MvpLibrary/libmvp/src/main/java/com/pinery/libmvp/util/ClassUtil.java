package com.pinery.libmvp.util;

import java.lang.reflect.ParameterizedType;

/**
 * class类型工具类
 *
 * Created by hesong on 2017/9/28.
 */

public class ClassUtil {

  /**
   * 获取obj对象所属类型的第i个泛型参数类型的生成的对象
   * @param obj
   * @param i
   * @param <T>
   * @return
   */
  public static <T> T getT(Object obj, int i){
    try {
      //获取obj所属类型的参数类型
      ParameterizedType parameterizedType = ((ParameterizedType)obj.getClass().getGenericSuperclass());
      //获取第i个参数所属类型
      Class<T> clazz = (Class<T>)parameterizedType.getActualTypeArguments()[i];
      //实例化对象
      return clazz.newInstance();
    }catch (Exception ex){
      ex.printStackTrace();
    }

    return null;
  }


}
