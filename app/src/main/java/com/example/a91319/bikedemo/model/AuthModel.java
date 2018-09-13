package com.example.a91319.bikedemo.model;

import com.example.a91319.bikedemo.contract.AuthContract;
import com.example.a91319.bikedemo.net.NetManager;
import com.example.a91319.bikedemo.net.requests.LoginRequest;
import com.example.a91319.bikedemo.net.requests.UserRegisterRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.OauthResponese;
import com.example.a91319.bikedemo.net.services.AuthService;

import retrofit2.Call;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public class AuthModel implements AuthContract.Model {
    @Override
    public Call<BaseResponse<String>> postRegisterUser(UserRegisterRequest userRegisterRequest) {
        return NetManager.getInstance().create(AuthService.class).postRegisterUser(userRegisterRequest);
    }

    @Override
    public Call<OauthResponese> postLoginUser(LoginRequest loginRequest) {
        return NetManager.getInstance().create(AuthService.class).postLogin(loginRequest);
    }
}
