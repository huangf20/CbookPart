package com.example.cbookpart.api;

import com.example.cbookpart.choiceness.data.ResultBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    String baseUrl="https://cbook.zhaoxitech.com/";

    @GET("system/homepage/list")
    Observable<ResultBean>getList(@Query("pageId")int pageId,@Query("seq")int seq);
}
