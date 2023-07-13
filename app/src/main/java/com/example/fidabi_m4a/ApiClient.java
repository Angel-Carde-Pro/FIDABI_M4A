package com.example.fidabi_m4a;

import com.example.fidabi_m4a.service.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class ApiClient {
    private static Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoginInterceptor = new HttpLoggingInterceptor();
        httpLoginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoginInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder( )
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://localhost:8080/")
                .client(okHttpClient)
                .build();
        return retrofit;
    }
    public static UserService getUserService(){
        UserService userService= getRetrofit().create(UserService.class);
        return userService;
    }
}
