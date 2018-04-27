package com.pinery.libmvp.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pinery.libmvp.util.LogUtil;

/**
 * Created by hesong on 2017/9/29.
 */

public class BFragment extends Fragment {

  @Override public void onAttach(Context context) {
    super.onAttach(context);

    LogUtil.i(getClass().getName());
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);

    LogUtil.i(getClass().getName());
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    LogUtil.i(getClass().getName());
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    LogUtil.i(getClass().getName());

    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    LogUtil.i(getClass().getName());
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    LogUtil.i(getClass().getName());
  }

  @Override public void onStart() {
    super.onStart();

    LogUtil.i(getClass().getName());
  }

  @Override public void onResume() {
    super.onResume();

    LogUtil.i(getClass().getName());
  }

  @Override public void onPause() {
    super.onPause();

    LogUtil.i(getClass().getName());
  }

  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    LogUtil.i(getClass().getName());
  }

  @Override public void onStop() {
    super.onStop();

    LogUtil.i(getClass().getName());
  }

  @Override public void onDestroyView() {
    super.onDestroyView();

    LogUtil.i(getClass().getName());
  }

  @Override public void onDestroy() {
    super.onDestroy();

    LogUtil.i(getClass().getName());
  }

  @Override public void onDetach() {
    super.onDetach();

    LogUtil.i(getClass().getName());
  }

}
