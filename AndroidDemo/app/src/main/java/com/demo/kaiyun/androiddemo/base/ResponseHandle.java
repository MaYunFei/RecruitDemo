package com.demo.kaiyun.androiddemo.base;

import android.text.TextUtils;

import com.demo.kaiyun.androiddemo.bean.ResultBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.demo.kaiyun.androiddemo.base.BaseActivity.showMessage;

public abstract class ResponseHandle<T> implements Callback<ResultBean<T>> {
    @Override
    public void onResponse(Call<ResultBean<T>> call, Response<ResultBean<T>> response) {
        if (response.isSuccessful()){
            ResultBean<T> result = response.body();
            if (result.isSuccess()){
                onSuccess(result.getBody());
            }else {
                onError();
                String errMsg = result.getErrMsg();
                showMessage(TextUtils.isEmpty(errMsg)?"服务器异常":errMsg);
            }
        }else {
            onError();
            showMessage("服务器异常");
        }
    }

    protected void onError() {

    }

    protected abstract void onSuccess(T data);

    @Override
    public void onFailure(Call<ResultBean<T>> call, Throwable t) {
        showMessage(t.getMessage());
    }


}