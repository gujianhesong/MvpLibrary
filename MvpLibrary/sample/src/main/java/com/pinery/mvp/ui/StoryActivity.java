package com.pinery.mvp.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.pinery.mvp.R;
import com.pinery.mvp.bean.Joke;
import com.pinery.mvp.bean.JokeInfo;
import com.pinery.mvp.constract.StoryConstract;
import com.pinery.mvp.model.StoryModel;
import com.pinery.mvp.presenter.StoryPresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * 故事列表页面
 *
 * Created by hesong on 2017/9/28.
 */

public class StoryActivity extends BaseWrapperActivity<StoryPresenter, StoryModel> implements
    StoryConstract.View{

  private RecyclerView mRecyclerView;
  private StoryAdapter mAdapter;

  private List<JokeInfo> mList = new ArrayList<>();

  @Override public int getLayoutId() {
    return R.layout.activity_story;
  }

  @Override public void initViews() {
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    mAdapter = new StoryAdapter();
    mRecyclerView.setAdapter(mAdapter);

  }

  @Override public void initData() {
    showProgressDialog();

    mPresenter.requestContent();
  }

  @Override public void showJoke(Joke joke) {
    if(joke != null && joke.getResult() != null){
      ArrayList<JokeInfo> list = joke.getResult().getJokeInfoArrayList();

      if(list != null){
        mList.addAll(list);
      }

      mAdapter.notifyDataSetChanged();

      dismissProgressDialog();

    }
  }

  @Override public void toastError(Throwable throwable) {
    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
  }

  private class StoryAdapter extends RecyclerView.Adapter<StroyViewHolder>{

    @Override public StroyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_story, null);

      return new StroyViewHolder(view);
    }

    @Override public void onBindViewHolder(StroyViewHolder holder, int position) {
      JokeInfo jokeInfo = mList.get(position);
      if(jokeInfo != null){
        holder.tvContent.setText(jokeInfo.getContent());
        holder.tvTime.setText(jokeInfo.getAddTime());
      }
    }

    @Override public int getItemCount() {
      return mList.size();
    }
  }

  private class StroyViewHolder extends RecyclerView.ViewHolder{
    TextView tvContent;
    TextView tvTime;

    public StroyViewHolder(View itemView) {
      super(itemView);

      tvContent = (TextView) itemView.findViewById(R.id.tv_content);
      tvTime = (TextView) itemView.findViewById(R.id.tv_time);

    }
  }

}
