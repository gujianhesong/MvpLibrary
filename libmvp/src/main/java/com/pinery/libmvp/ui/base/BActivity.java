package com.pinery.libmvp.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.pinery.libmvp.util.LogUtil;

/**
 * Created by hesong on 2017/9/29.
 */

public class BActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    LogUtil.i(getClass().getName());
  }

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);

    LogUtil.i(getClass().getName());
  }

  @Override protected void onStart() {
    super.onStart();

    LogUtil.i(getClass().getName());
  }

  @Override protected void onRestart() {
    super.onRestart();

    LogUtil.i(getClass().getName());
  }

  @Override protected void onResume() {
    super.onResume();

    LogUtil.i(getClass().getName());
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    LogUtil.i(getClass().getName());
  }

  @Override protected void onPause() {
    super.onPause();

    LogUtil.i(getClass().getName());
  }

  @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);

    LogUtil.i(getClass().getName());
  }

  @Override protected void onStop() {
    super.onStop();

    LogUtil.i(getClass().getName());
  }

  @Override protected void onDestroy() {
    super.onDestroy();

    LogUtil.i(getClass().getName());
  }
}
