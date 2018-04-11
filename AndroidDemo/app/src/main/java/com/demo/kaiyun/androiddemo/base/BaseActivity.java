package com.demo.kaiyun.androiddemo.base;

import android.support.v7.app.AppCompatActivity;

import com.demo.kaiyun.androiddemo.App;
import com.demo.kaiyun.androiddemo.http.ApiService;


public class BaseActivity extends AppCompatActivity {
    protected ApiService apiService = ((App)getApplication()).getApiService();
}
