package com.demo.kaiyun.androiddemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.Student;
import com.demo.kaiyun.androiddemo.ui.company.CompanyMainActivity;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private EditText mEtPhone;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnRegistered;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioStudent;
    private RadioButton mRadioCompany;

    public static final int TYPE_STUDENT = 0;
    public static final int TYPE_COMPANY = 1;

    private int type = TYPE_STUDENT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);//这两句就可以让actionBar的图标可以响应点击事件
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//这一句主要用于后面返回效果，后面会讲
        setTitle("登录");
        initView();
        mRadioGroup.setOnCheckedChangeListener(this);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnRegistered = (Button) findViewById(R.id.btn_registered);
        mBtnRegistered.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(RegisteredActivity.class);
            }
        });
        mBtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mEtPhone.getText().toString();
                String password = mEtPassword.getText().toString();
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "手机号或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (type == TYPE_STUDENT){
                    mApiService.getStudent(phone, password)
                            .enqueue(new ResponseHandle<Student>() {
                                @Override
                                protected void onSuccess(Student student) {
                                    SPUtils.setUserId(student.getId());
                                    SPUtils.setType(LoginActivity.TYPE_STUDENT);
                                    startActivity(MainActivity.class);
                                    finish();
                                }
                            });

                }else {
                    mApiService.getCompany(phone, password)
                            .enqueue(new ResponseHandle<Company>() {
                                @Override
                                protected void onSuccess(Company data) {
                                    SPUtils.setUserId(data.getId());
                                    SPUtils.setType(LoginActivity.TYPE_COMPANY);
                                    Intent intent = new Intent(LoginActivity.this,CompanyMainActivity.class);
                                    intent.putExtra("data",data);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                }

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
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mRadioStudent = (RadioButton) findViewById(R.id.radio_student);
        mRadioCompany = (RadioButton) findViewById(R.id.radio_company);
        if (SPUtils.getType() == LoginActivity.TYPE_STUDENT) {
            mRadioStudent.setChecked(true);
            mRadioCompany.setChecked(false);
        }else {
            mRadioStudent.setChecked(false);
            mRadioCompany.setChecked(true);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radio_company:
                type = TYPE_COMPANY;
                SPUtils.setType(type);
                break;
            case R.id.radio_student:
                type = TYPE_STUDENT;
                SPUtils.setType(type);
                break;
        }
    }
}

