package com.demo.kaiyun.androiddemo.ui.student;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseActivity;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.School;
import com.demo.kaiyun.androiddemo.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class ResumeEditActivity extends BaseActivity {

    private Toolbar toolbar;
    Student mStudent;
    private List<School> mSchoolList = new ArrayList<>();
    private Spinner mSpinner;
    private ArrayAdapter<School> mSpinnerAdapter;
    private AppCompatEditText mEtName;
    private RadioGroup mRadioGroup;
    private AppCompatEditText mEtAge;
    private AppCompatEditText mEtNumber;
    private AppCompatEditText mEtEmail;
    private AppCompatEditText mEtAddress;
    private AppCompatEditText mEtExperience;
    private RadioButton mMan;
    private RadioButton mUnman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_edit);
        mStudent = (Student) getIntent().getSerializableExtra("data");
        initView();

        toolbar = findViewById(R.id.toolbar);
        mSpinner = findViewById(R.id.spinner_school);
        mSpinnerAdapter = new ArrayAdapter<School>(this, android.R.layout.simple_spinner_item, mSchoolList);
        mSpinner.setAdapter(mSpinnerAdapter);
        setSupportActionBar(toolbar);
        setTitle("编辑简历");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//这一句主要用于后面返回效果，后面会讲

        if (mStudent == null) {
            showMessage("数据错误");
            finish();
        }

        bindData();

        mApiService.getSchoolList()
                .enqueue(new ResponseHandle<List<School>>() {
                    @Override
                    protected void onSuccess(List<School> data) {
                        mSchoolList.clear();
                        mSchoolList.addAll(data);
                        mSpinnerAdapter.notifyDataSetChanged();
                        for (int i = 0; i < data.size(); i++) {
                            School school = data.get(i);
                            if (school.getId().equals(mStudent.getSchoolId())){
                                mSpinner.setSelection(i,true);
                            }
                        }
                    }
                });

//        mSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                School school = mSchoolList.get(position);
                mStudent.setSchoolId(school.getId()+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void bindData() {
        mEtName.setText(mStudent.getName());
        if ("女".equals(mStudent.getSex())) {
            mUnman.setChecked(true);
            mMan.setChecked(false);
        } else {
            mUnman.setChecked(false);
            mMan.setChecked(true);
        }
        mEtAge.setText(mStudent.getAgo());
        mEtNumber.setText(mStudent.getNumber());
        mEtEmail.setText(mStudent.getEmail());
        mEtAddress.setText(mStudent.getAndress());
        mEtExperience.setText(mStudent.getExperience());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.resume_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.toolbar_save:
                saveData();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveData() {
        mStudent.setName(mEtName.getText().toString());
        mStudent.setAgo(mEtAge.getText().toString());
        mStudent.setNumber(mEtNumber.getText().toString());
        mStudent.setEmail(mEtEmail.getText().toString());
        mStudent.setAndress(mEtAddress.getText().toString());
        mStudent.setExperience(mEtExperience.getText().toString());


        mApiService.updateStudent(
                mStudent.getId(),
                mStudent.getName(),
                mStudent.getSex(),
                mStudent.getAgo(),
                mStudent.getNumber(),
                mStudent.getEmail(),
                mStudent.getAndress(),
                mStudent.getSchoolId(),
                mStudent.getExperience())
                .enqueue(new ResponseHandle<Student>() {
                    @Override
                    protected void onSuccess(Student data) {
                        finish();
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
        mEtName = (AppCompatEditText) findViewById(R.id.et_name);
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
        mEtAge = (AppCompatEditText) findViewById(R.id.et_age);
        mEtNumber = (AppCompatEditText) findViewById(R.id.et_number);
        mEtEmail = (AppCompatEditText) findViewById(R.id.et_email);
        mEtAddress = (AppCompatEditText) findViewById(R.id.et_address);
        mEtExperience = (AppCompatEditText) findViewById(R.id.et_experience);
        mMan = (RadioButton) findViewById(R.id.man);
        mUnman = (RadioButton) findViewById(R.id.unman);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.man:
                        mStudent.setSex("男");
                        break;
                    case R.id.unman:
                        mStudent.setSex("女");
                        break;
                }
            }
        });

    }
}
