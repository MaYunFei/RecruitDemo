package com.demo.kaiyun.androiddemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.Student;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisteredActivity extends BaseActivity {
    private EditText mEtPhone;
    private EditText mEtPassword;
    private Button mBtnRegistered;
    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);//这两句就可以让actionBar的图标可以响应点击事件
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//这一句主要用于后面返回效果，后面会讲
        setTitle("注册");
        setContentView(R.layout.activity_registered);

        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnRegistered = (Button) findViewById(R.id.btn_registered);
        mBtnLogin = (Button) findViewById(R.id.btn_login);

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
                apiService.addStudent(phone,password)
                        .enqueue(new ResponseHandle<Student>() {
                            @Override
                            protected void onSuccess(Student student) {
                                SPUtils.setUserId(student.getId());
                                startActivity(MainActivity.class);
                            }
                        });
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
}
