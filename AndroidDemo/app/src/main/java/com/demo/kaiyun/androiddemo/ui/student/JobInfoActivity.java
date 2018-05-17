package com.demo.kaiyun.androiddemo.ui.student;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Job;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

public class JobInfoActivity extends BaseActivity {

    private Job mJob;
    private TextView mTvName;
    private TextView mTvResponsibility;
    private TextView mTvRequire;
    private TextView mTvMoney;
    private TextView mTvEducation;
    private Button mBtnSend;

    public static void startJobInfoActivity(Context context, Job job) {
        Intent intent = new Intent(context, JobInfoActivity.class);
        intent.putExtra("data", job);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("招聘详情");
        mJob = (Job) getIntent().getSerializableExtra("data");

        if (mJob == null) {
            showMessage("数据异常");
            finish();
            return;
        }


        initView();

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApiService.sendResume(SPUtils.getUserId(),mJob.getId())
                        .enqueue(new ResponseHandle<String>() {
                            @Override
                            protected void onSuccess(String data) {
                                Toast.makeText(JobInfoActivity.this, data, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        if (!isFinishing()) {
            onBackPressed();
        }
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvResponsibility = (TextView) findViewById(R.id.tv_responsibility);
        mTvRequire = (TextView) findViewById(R.id.tv_require);
        mTvMoney = (TextView) findViewById(R.id.tv_money);
        mTvEducation = (TextView) findViewById(R.id.tv_education);
        mBtnSend = (Button) findViewById(R.id.btn_send);

        mTvName.setText(mJob.getName());
        mTvResponsibility.setText(mJob.getResponsibility());
        mTvRequire.setText(mJob.getRequire());
        mTvMoney.setText(mJob.getMoney());
        mTvEducation.setText(mJob.getEducation());


    }
}
