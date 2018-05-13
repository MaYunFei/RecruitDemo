package com.demo.kaiyun.androiddemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.demo.kaiyun.androiddemo.App;
import com.demo.kaiyun.androiddemo.http.ApiService;


public class BaseActivity extends AppCompatActivity {
    protected ApiService mApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = ((App) getApplication()).getApiService();
    }

    protected void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    public static void showMessage(String message) {
        Toast.makeText(App.getApp(), message, Toast.LENGTH_SHORT).show();
    }


}
