package com.demo.kaiyun.androiddemo.ui.company;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.School;
import com.demo.kaiyun.androiddemo.bean.Student;
import com.demo.kaiyun.androiddemo.bean.StudentInfo;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import java.io.Serializable;

public class StudentInfoActivity extends BaseActivity {

    Student mStudent;
    private Integer studentId;

    public static void startStudentInfoActivity(Context context, Student student) {
        Intent intent = new Intent(context, StudentInfoActivity.class);
        intent.putExtra("data", student);
        context.startActivity(intent);
    }

    SwipeRefreshLayout mRefreshLayout;
    private TextView mTvName;
    private TextView mTvSex;
    private TextView mTvAge;
    private TextView mTvNumber;
    private TextView mTvEmail;
    private TextView mTvAddress;
    private TextView mTvSchool;
    private TextView mTvExperience;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        Student student = (Student) getIntent().getSerializableExtra("data");
        if (student == null) {
            finish();
            return;
        }
        setTitle(student.getName());
        studentId = student.getId();
        initView();
        getData();
    }

    private void getData() {
        mApiService.getStudentInfoByUserId(studentId)
                .enqueue(new ResponseHandle<StudentInfo>() {
                    @Override
                    protected void onSuccess(StudentInfo data) {
                        mStudent = data.getStudent();
                        if (mStudent == null) {
                            showMessage("服务器异常");
                            return;
                        }
                        Log.i(getClass().getName(), data.toString());

                        School school = data.getSchool();
                        if (school != null) {
                            mTvSchool.setText(school.getName());
                        }
                        bindView();

                        mRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    protected void onError() {
                        super.onError();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
    }


    private void initView() {
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvSex = (TextView) findViewById(R.id.tv_sex);
        mTvAge = (TextView) findViewById(R.id.tv_age);
        mTvNumber = (TextView) findViewById(R.id.tv_number);
        mTvEmail = (TextView) findViewById(R.id.tv_email);
        mTvAddress = (TextView) findViewById(R.id.tv_address);
        mTvSchool = (TextView) findViewById(R.id.tv_school);
        mTvExperience = (TextView) findViewById(R.id.tv_experience);
    }

    private void bindView() {
        mTvName.setText(mStudent.getName());
        mTvSex.setText(mStudent.getSex());
        mTvAge.setText(mStudent.getAgo());
        mTvNumber.setText(mStudent.getNumber());
        mTvEmail.setText(mStudent.getEmail());
        mTvAddress.setText(mStudent.getAndress());
        mTvExperience.setText(mStudent.getExperience());
    }
}
