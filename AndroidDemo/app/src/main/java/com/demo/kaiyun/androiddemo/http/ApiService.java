package com.demo.kaiyun.androiddemo.http;


import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.ResultBean;
import com.demo.kaiyun.androiddemo.bean.Student;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {
    @GET("company/listcompany")
    Call<ResultBean<List<Company>>> getCompanyList();

//    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("student/addStudent")
    @FormUrlEncoded
    Call<ResultBean<Student>> addStudent(@Field("number") String number, @Field("password")String password);




    @GET("student/queryStudentByPassword")
    Call<ResultBean<Student>> getStudent(@Query("number")String number, @Query("password") String password);

}
