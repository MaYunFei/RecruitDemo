package com.demo.kaiyun.androiddemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.demo.kaiyun.androiddemo.http.ApiService;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {
    ApiService apiService;
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SPUtils.init(this);
        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("test",message);
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit build = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://192.168.99.213:8080/demo/").build();
        apiService = build.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public static Context getApp() {
        return instance;
    }
}
