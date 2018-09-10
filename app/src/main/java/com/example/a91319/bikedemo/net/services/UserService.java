package com.example.a91319.bikedemo.net.services;

import com.example.a91319.bikedemo.net.requests.MoneyRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.MyInfoResponese;
import com.example.a91319.bikedemo.net.responeses.RideRecordResponese;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public interface UserService  {

    //获取我的信息
    @GET("api/my_info")
    Call<BaseResponse<MyInfoResponese>> getMyinfo();


    //获取骑行记录
    @GET("api/my_riders")
    Call<BaseResponse<ArrayList<RideRecordResponese>>> getMyRiders();

    //获取正在骑行记录
    @GET("api/current_rider")
    Call<BaseResponse<ArrayList<RideRecordResponese>>> getMyCurrentRiders(@QueryMap Map<String,Object> map);

    //缴纳押金
    @POST("api/deposit")
    Call<BaseResponse<String>> deposit();

    //退还押金
    @DELETE("api/deposit")
    Call<BaseResponse<String>> backdeposit();

    //充值
    @POST("api/pay_money")
    Call<BaseResponse<String>> payMoney(@Body MoneyRequest moneyRequest);











}
