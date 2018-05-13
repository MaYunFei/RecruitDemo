package com.demo.kaiyun.androiddemo.ui.student;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.bean.Job;

public class JobInfoActivity extends BaseActivity {

    private Job mJob;

    public static void startJobInfoActivity(Context context,Job job){
        Intent intent = new Intent(context,JobInfoActivity.class);
        intent.putExtra("data",job);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mJob = (Job) getIntent().getSerializableExtra("data");

        if (mJob == null){
            showMessage("数据异常");
            finish();
            return;
        }


    }
}
