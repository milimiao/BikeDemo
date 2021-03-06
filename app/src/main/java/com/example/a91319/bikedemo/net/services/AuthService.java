package com.example.a91319.bikedemo.net.services;

import com.example.a91319.bikedemo.net.requests.LoginRequest;
import com.example.a91319.bikedemo.net.requests.RefreshTokenRequest;
import com.example.a91319.bikedemo.net.requests.UserRegisterRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.OauthResponese;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 黄君豪 on 2018/9/10.
 */

public interface AuthService {

    /**
     * 用户登录
     * @param loginRequest
     * @return
     */
    @POST("api/oauth/token")
    Call<OauthResponese> postLogin(@Body LoginRequest loginRequest);


    /**
     * 用户注册
     * @param userRegisterRequest
     * @return
     */
    @POST("api/register")
    Call<BaseResponse<String>> postRegisterUser(@Body UserRegisterRequest userRegisterRequest);

    /**
     * 刷新token
     * @param refreshTokenRequest
     * @return
     */
    @POST("api/oauth/token")
    Call<OauthResponese> postRefreshToken(@Body RefreshTokenRequest refreshTokenRequest);





}
