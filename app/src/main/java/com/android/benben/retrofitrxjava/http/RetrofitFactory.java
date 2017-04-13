package com.android.benben.retrofitrxjava.http;

import android.util.Log;

import com.android.benben.retrofitrxjava.http.config.HttpConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Time      2017/4/10 13:36 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class RetrofitFactory {
    private static RetrofitFactory mRetrofitFactory;
    private static APIFunction mAPIFunction;

    private RetrofitFactory() {
        OkHttpClient mOkhttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .readTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .writeTimeout(HttpConfig.HTTP_TIME, TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加Gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加RxJava转换器
                .client(mOkhttpClient)
                .build();
        mAPIFunction = mRetrofit.create(APIFunction.class);
    }

    public static RetrofitFactory getInstence() {
        if (mRetrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (mRetrofitFactory == null) {
                    mRetrofitFactory = new RetrofitFactory();
                }
            }
        }
        return mRetrofitFactory;
    }

    public APIFunction API() {
        return mAPIFunction;
    }



    public static String TAG = "----";


}
