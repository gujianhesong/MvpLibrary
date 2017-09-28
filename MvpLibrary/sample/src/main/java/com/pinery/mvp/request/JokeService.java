package com.pinery.mvp.request;

import com.pinery.mvp.bean.Joke;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 笑话请求接口
 *
 * Created by hesong on 2017/9/28.
 */

public interface JokeService {

  @GET("text")
  Observable<Joke> requestJoke(@Query("pagenum") int pageNum, @Query("pagesize") int pageSize, @Query("appkey") String appKey);

}
