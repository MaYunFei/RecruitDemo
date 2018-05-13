package com.demo.kaiyun.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.kaiyun.androiddemo.ui.LoginActivity;
import com.demo.kaiyun.androiddemo.ui.MainActivity;
import com.demo.kaiyun.androiddemo.ui.company.CompanyMainActivity;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        int userId = SPUtils.getUserId();
        if (userId>0){
            if (SPUtils.getType() == LoginActivity.TYPE_STUDENT){

            startActivity(new Intent(this, MainActivity.class));
            }else {
                startActivity(new Intent(this, CompanyMainActivity.class));
            }
        }else {
            startActivity(new Intent(this, LoginActivity.class));
        }

        finish();
    }
}
