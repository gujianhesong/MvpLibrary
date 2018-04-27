package com.pinery.mvp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import com.pinery.libmvp.ui.BaseMvpActivity;
import com.pinery.mvp.R;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends BaseMvpActivity {

  private ViewPager viewPager;
  private PagerTitleStrip titleStrip;
  private PagerTabStrip tabStrip;

  @Override public int getLayoutId() {
    return R.layout.activity_frament;
  }

  @Override public void initViews() {
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    tabStrip = (PagerTabStrip) findViewById(R.id.pager_tab);
  }

  @Override public void initData() {

    init();
  }

  private void init() {
    List<String> titles = new ArrayList<>();
    titles.add("First Fragment");
    titles.add("Second Fragment");

    List<Fragment> fragments = new ArrayList<>();
    fragments.add(new FirstFragment());
    fragments.add(new SecondFragment());
    FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);

    viewPager.setAdapter(adapter);
  }

  public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTitles;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
      super(fm);
      mFragments = fragments;
      mTitles = titles;
    }

    @Override public Fragment getItem(int arg0) {
      return mFragments.get(arg0);
    }

    @Override public int getCount() {
      return mFragments.size();
    }

    @Override public CharSequence getPageTitle(int position) {
      return mTitles.get(position);
    }
  }
}
