package com.demo.kaiyun.androiddemo.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.Student;
import com.demo.kaiyun.androiddemo.ui.company.CompanyMainActivity;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import static com.demo.kaiyun.androiddemo.ui.LoginActivity.TYPE_COMPANY;
import static com.demo.kaiyun.androiddemo.ui.LoginActivity.TYPE_STUDENT;

public class RegisteredActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    private EditText mEtPhone;
    private EditText mEtPassword;
    private Button mBtnRegistered;
    private Button mBtnLogin;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioStudent;
    private RadioButton mRadioCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);//这两句就可以让actionBar的图标可以响应点击事件
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//这一句主要用于后面返回效果，后面会讲
        setTitle("注册");
        setContentView(R.layout.activity_registered);
        initView();


        mBtnRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = mEtPhone.getText().toString();
                String password = mEtPassword.getText().toString();
                if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)){
                    showMessage("手机号或密码不能为空");
                    return;
                }
//                Student student = new Student();
//                student.setName("15101578395");

                if (SPUtils.getType() == TYPE_STUDENT){
                    mApiService.addStudent(phone,password)
                            .enqueue(new ResponseHandle<Student>() {
                                @Override
                                protected void onSuccess(Student student) {
                                    SPUtils.setUserId(student.getId());
                                    startActivity(MainActivity.class);
                                }
                            });
                }else {
                    mApiService.addCompany(phone,password)
                            .enqueue(new ResponseHandle<Company>() {
                                @Override
                                protected void onSuccess(Company data) {
                                    SPUtils.setUserId(data.getId());
                                    startActivity(CompanyMainActivity.class);
                                }
                            });
                }


            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        if (!isFinishing()){
            onBackPressed();
        }
        return super.onSupportNavigateUp();
    }

    private void initView() {
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnRegistered = (Button) findViewById(R.id.btn_registered);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mRadioStudent = (RadioButton) findViewById(R.id.radio_student);
        mRadioCompany = (RadioButton) findViewById(R.id.radio_company);
        if (SPUtils.getType() == TYPE_STUDENT) {
            mRadioStudent.setChecked(true);
            mRadioCompany.setChecked(false);
        }else {
            mRadioStudent.setChecked(false);
            mRadioCompany.setChecked(true);
        }

        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radio_company:
                SPUtils.setType(TYPE_COMPANY);
                break;
            case R.id.radio_student:
                SPUtils.setType(TYPE_STUDENT);
                break;
        }
    }
}
