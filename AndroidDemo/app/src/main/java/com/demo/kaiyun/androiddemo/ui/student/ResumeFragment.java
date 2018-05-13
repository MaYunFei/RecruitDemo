package com.demo.kaiyun.androiddemo.ui.student;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.base.BaseFragment;
import com.demo.kaiyun.androiddemo.base.ResponseHandle;
import com.demo.kaiyun.androiddemo.bean.School;
import com.demo.kaiyun.androiddemo.bean.Student;
import com.demo.kaiyun.androiddemo.bean.StudentInfo;
import com.demo.kaiyun.androiddemo.utils.SPUtils;

import static com.demo.kaiyun.androiddemo.base.BaseActivity.showMessage;

public class ResumeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout mRefreshLayout;
    Student mStudent;
    private TextView mTvName;
    private TextView mTvSex;
    private TextView mTvAge;
    private TextView mTvNumber;
    private TextView mTvEmail;
    private TextView mTvAddress;
    private TextView mTvSchool;
    private TextView mTvExperience;

    public ResumeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resume, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        initView(view);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
        mRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.resume_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_edit:
                goToEdit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mApiService.getStudentInfoByUserId(SPUtils.getUserId())
                .enqueue(new ResponseHandle<StudentInfo>() {
                    @Override
                    protected void onSuccess(StudentInfo data) {
                        mStudent = data.getStudent();
                        if (mStudent == null){
                            showMessage("服务器异常");
                            return;
                        }
                        Log.i(getClass().getName(), data.toString());

                        School school = data.getSchool();
                        if (school != null){
                            mTvSchool.setText(school.getName());
                        }
                        bindView();

                        if (TextUtils.isEmpty(mStudent.getName())) {
                            goToEdit();
                        }
                        mRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    protected void onError() {
                        super.onError();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
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


    private void goToEdit() {
        if (mStudent == null) {
            return;
        }
        Intent intent = new Intent(getActivity(), ResumeEditActivity.class);
        intent.putExtra("data", mStudent);
        startActivity(intent);
    }

    private void initView(View view) {
        mTvName = (TextView) view.findViewById(R.id.tv_name);
        mTvSex = (TextView) view.findViewById(R.id.tv_sex);
        mTvAge = (TextView) view.findViewById(R.id.tv_age);
        mTvNumber = (TextView) view.findViewById(R.id.tv_number);
        mTvEmail = (TextView) view.findViewById(R.id.tv_email);
        mTvAddress = (TextView) view.findViewById(R.id.tv_address);
        mTvSchool = (TextView) view.findViewById(R.id.tv_school);
        mTvExperience = (TextView) view.findViewById(R.id.tv_experience);
    }

}
