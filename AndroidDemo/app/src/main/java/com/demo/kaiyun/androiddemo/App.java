package com.demo.kaiyun.androiddemo;

import android.app.Application;
import android.util.Log;

import com.demo.kaiyun.androiddemo.http.ApiService;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {
    ApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
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
        Retrofit build = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://192.168.50.81:8080/demo/").build();
        apiService = build.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
