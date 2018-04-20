package com.demo.kaiyun.androiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.kaiyun.androiddemo.ui.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
