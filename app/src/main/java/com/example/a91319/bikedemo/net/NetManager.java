package com.example.a91319.bikedemo.net;

import com.example.a91319.bikedemo.managers.SpManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 黄君豪 on 2018/9/8.
 */

public class NetManager {

    private static Retrofit instance = null;

    //服务器地址
    public static final String BASE_URL = "https://wx.duyoucai,com/";


    private NetManager() {

    }

    public static synchronized Retrofit getInstance() {

        if(instance==null){

            synchronized (NetManager.class){
                Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .authenticator(new MyAuthenticator())
                        .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //重新调用request 实现一个公共的头部
                        String authString="Bearer "+ SpManager.getDefaultSp().getString("access_token");
                        Request request = chain.request()
                                .newBuilder()
                                .header("Accept","application/json")
                                .header("Authorization",authString)  //每次访问都会携带这个token 用户认证
                                .build();

                        return chain.proceed(request);
                    }
                }).build();

                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(okHttpClient)
                        .baseUrl(BASE_URL)
                        .build();
                instance = retrofit;
            }

        }

        return instance;
    }
}
