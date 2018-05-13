package com.demo.kaiyun.androiddemo.http;


import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.ResultBean;
import com.demo.kaiyun.androiddemo.bean.School;
import com.demo.kaiyun.androiddemo.bean.Student;
import com.demo.kaiyun.androiddemo.bean.StudentInfo;

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
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("company/listCompany")
    Call<ResultBean<List<Company>>> getCompanyList();

    @POST("company/queryCompanyByPassword")
    @FormUrlEncoded
    Call<ResultBean<Company>> getCompany(@Field("number")String number, @Field("password") String password);

    @POST("company/addCompany")
    @FormUrlEncoded
    Call<ResultBean<Company>> addCompany(@Field("number") String number, @Field("password")String password);

//    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    @POST("student/addStudent")
    @FormUrlEncoded
    Call<ResultBean<Student>> addStudent(@Field("number") String number, @Field("password")String password);




    @POST("student/queryStudentByPassword")
    @FormUrlEncoded
    Call<ResultBean<Student>> getStudent(@Field("number")String number, @Field("password") String password);

    @GET("student/get/{userId}")
    Call<ResultBean<StudentInfo>> getStudentInfoByUserId(@Path("userId") int userId);

    @POST("student/update/{userId}")
    @FormUrlEncoded
    Call<ResultBean<Student>> updateStudent(@Path("userId") int userId,
                                     @Field("name")String name,
                                     @Field("sex")String sex,
                                     @Field("age")String age,
                                     @Field("number")String number,
                                     @Field("email")String email,
                                     @Field("address")String address,
                                     @Field("school")String school,
                                     @Field("experience")String experience

    );


    @GET("school/listSchool")
    Call<ResultBean<List<School>>> getSchoolList();

}
