package com.demo.kaiyun.androiddemo.http;

import com.demo.kaiyun.androiddemo.bean.Company;
import com.demo.kaiyun.androiddemo.bean.Student;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;


public class ApiServiceTest {

    ApiService apiService;

    @Before
    public void setUp(){


        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                System.out.println(message);
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit build = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl("http://192.168.50.81:8080/demo/").build();
        apiService = build.create(ApiService.class);
    }

    @Test
    public void getCompanyList() throws Exception {
        Call<List<Company>> companyList = apiService.getCompanyList();
        Response<List<Company>> execute = companyList.execute();
//        companyList.enqueue(new Callback<List<Company>>() {
//            @Override
//            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
//                System.out.println("123");
//            }
//
//            @Override
//            public void onFailure(Call<List<Company>> call, Throwable t) {
//
//            }
//        });
    }

    @Test
    public void getStudent() throws Exception{
//        RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        Response<Student> response = apiService.getStudent("123","123").execute();
        Student body = response.body();
        System.out.println(body);
//        .enqueue(new Callback<Student>() {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response) {
//
//                System.out.println(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Student> call, Throwable t) {
//                System.out.println(t);
//            }
//        });
        ;

    }

}