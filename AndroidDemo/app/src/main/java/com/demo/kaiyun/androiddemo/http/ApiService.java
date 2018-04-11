package com.demo.kaiyun.androiddemo.http;


import com.demo.kaiyun.androiddemo.bean.Company;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("company/listcompany")
    Call<List<Company>> getCompanyList();
}
