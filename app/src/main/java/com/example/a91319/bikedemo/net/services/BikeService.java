package com.example.a91319.bikedemo.net.services;

import com.example.a91319.bikedemo.net.requests.BikeRequest;
import com.example.a91319.bikedemo.net.requests.LocationRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.BikeResponese;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public interface BikeService {

    //获取附近单车
    @GET("api/bikes")
    Call<BaseResponse<ArrayList<BikeResponese>>> getNearBikes(@QueryMap Map<String,Object> locationMap);

    //手动添加单车
    @POST("api/generate_bikes")
    Call<BaseResponse<String>> generateBikeByLocation(@Body LocationRequest locationRequest);

    @POST("api/unlock")
    Call<BaseResponse<BikeResponese>> unlockBike(@Body BikeRequest bikeRequest);

    @POST("api/lock")
    Call<BaseResponse<BikeResponese>> lockBike(@Body BikeRequest bikeRequest);




}
