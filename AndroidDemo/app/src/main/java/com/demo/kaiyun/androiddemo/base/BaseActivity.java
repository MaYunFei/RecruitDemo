package com.demo.kaiyun.androiddemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.demo.kaiyun.androiddemo.App;
import com.demo.kaiyun.androiddemo.bean.ResultBean;
import com.demo.kaiyun.androiddemo.http.ApiService;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BaseActivity extends AppCompatActivity {
    protected ApiService apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = ((App) getApplication()).getApiService();
    }

    protected void startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }

    protected static void showMessage(String message) {
        Toast.makeText(App.getApp(), message, Toast.LENGTH_SHORT).show();
    }


}
