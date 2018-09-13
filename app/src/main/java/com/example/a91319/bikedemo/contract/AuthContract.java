package com.example.a91319.bikedemo.contract;

import com.example.a91319.bikedemo.net.requests.LoginRequest;
import com.example.a91319.bikedemo.net.requests.UserRegisterRequest;
import com.example.a91319.bikedemo.net.responeses.BaseResponse;
import com.example.a91319.bikedemo.net.responeses.OauthResponese;

import retrofit2.Call;

/**
 * Created by 黄君豪 on 2018/9/13.
 */

public interface AuthContract {
    interface Model {
        //注册
        Call<BaseResponse<String>> postRegisterUser(UserRegisterRequest userRegisterRequest);

        //登录
        Call<OauthResponese> postLoginUser(LoginRequest loginRequest);
    }

    interface View {
        void onRegisterSuccess();
        void showErrorMessahe(String message);

        void onLoginSuccess();
    }

    interface Presenter {

         void doRegisterUser(UserRegisterRequest userRegisterRequest);

         void doLoginUser(LoginRequest loginRequest);
    }
}
