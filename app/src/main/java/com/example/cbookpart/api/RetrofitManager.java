package com.example.cbookpart.api;

import com.example.cbookpart.choiceness.converter.CustomConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public class RetrofitManager {
    private static Retrofit mRetrofit;

    public static Retrofit retrofit() {
        if (mRetrofit == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BASIC);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .writeTimeout(30_1000, TimeUnit.MILLISECONDS)
                    .readTimeout(20_1000, TimeUnit.MILLISECONDS)
                    .connectTimeout(15_1000, TimeUnit.MILLISECONDS)
                    .addInterceptor(loggingInterceptor)
                    .build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.baseUrl)
                    .addConverterFactory(CustomConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return mRetrofit;
    }
}
