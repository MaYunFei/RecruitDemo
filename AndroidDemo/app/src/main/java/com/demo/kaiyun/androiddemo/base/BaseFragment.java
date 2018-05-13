package com.demo.kaiyun.androiddemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.demo.kaiyun.androiddemo.App;
import com.demo.kaiyun.androiddemo.http.ApiService;

public class BaseFragment extends Fragment{

    protected ApiService mApiService;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = ((App) (getActivity().getApplication())).getApiService();
    }
}
